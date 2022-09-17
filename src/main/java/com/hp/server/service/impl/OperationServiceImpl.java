package com.hp.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hp.server.dao.DeviceManagerMapper;
import com.hp.server.dao.OperationMapper;
import com.hp.server.dao.SysParameterMapper;
import com.hp.server.dao.SysTaskMapper;
import com.hp.server.dto.*;
import com.hp.server.entity.*;
import com.hp.server.enumeration.ModeStatus;
import com.hp.server.enumeration.ValueType;
import com.hp.server.onenet.entity.Device;
import com.hp.server.onenet.entity.Write;
import com.hp.server.onenet.entity.WriteOffline;
import com.hp.server.onenet.online.WriteOpe;
import com.hp.server.quartz.QuartzManager;
import com.hp.server.result.ResultBody;
import com.hp.server.service.OperationService;
import com.hp.server.utils.CodeUtil;
import com.hp.server.utils.DateUtil;
import com.hp.server.vo.*;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/22
 * @description:控制管理
 */
@Service
public class OperationServiceImpl implements OperationService {
    @Value(("${oneNet.apiKey}"))
    private String apiKey;
    @Value(("${oneNet.mode}"))
    private Integer mode;
    private static Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private QuartzManager quartzManager;
    @Resource
    private SysTaskMapper sysTaskMapper;
    @Resource
    private DeviceManagerMapper deviceManagerMapper;
    @Resource
    private SysParameterMapper sysParameterMapper;

    /**
     * 根据条件查询控制策略列表
     * @param dto  查询条件
     * @return
     */
    @Override
    public List<OperationControlVo> listOperationControl(OperationQueryDTO dto) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        if (sysUser.getUserOrigin() == 2) {
            dto.setCompanyId(sysUser.getCompanyId());
        } else {
            // 凡尔用户 运行调度页面能查看所有设备
            dto.setProductType(null);
        }
        List<OperationControlVo> operationControlList = operationMapper.listOperationControl(dto);
        for (OperationControlVo item : operationControlList) {
            if (item.getRegion() != null) {
                StringBuilder builder = new StringBuilder();
                builder.append(item.getRegion());
                if (item.getTower() != null) {
                    builder.append("/" + item.getTower());
                }
                if (item.getCell() != null) {
                    builder.append("/"+item.getCell());
                }
                item.setCommunity(builder.toString());
            } else {
                item.setCommunity("--");
            }

            if (item.getGroups() != null) {
                StringBuilder builder2 = new StringBuilder();
                builder2.append(item.getGroups());
                if (item.getSite() != null) {
                    builder2.append("/" + item.getSite());
                }
                if (item.getUnit() != null) {
                    builder2.append("/" + item.getUnit());
                }
                item.setUnitInfor(builder2.toString());
            } else {
                item.setUnitInfor("--");
            }

            if (item.getModeStatus() != null) {
                // 模块状态处理
                StringBuilder builder3 = new StringBuilder();
                String value = org.apache.commons.lang3.StringUtils.leftPad(Integer.toBinaryString(item.getModeStatus()), 16, "0");
                int a = value.indexOf("1");
                while (a != -1) {
                    builder3.append(ModeStatus.getEnumByKey(a).getMsg() + "\t");

                    a = value.indexOf("1", a + 1);//*从这个索引往后开始第一个出现的位置
                }
                item.setModeStatusName(builder3.toString());
            }

        }
        return operationControlList;
    }

    /**
     * 向服务器插入oneNet接收到的数据
     * @param receiveList oneNet数据列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOperation(List<OneNetReceiveVo> receiveList) {
        // 插入运行历史数据表
        for (OneNetReceiveVo item : receiveList) {
            OperationHistory vo = new OperationHistory();
            String value1 = item.getValue();
            String valueString = CodeUtil.hexStringToString(value1);
            String[] values = valueString.split(";");
            for (int i = 0; i < values.length ; i++) {
                String[] maps = values[i].split(":");
                String key = maps[0];
                String value = maps[1];
                switch (key){
                    case "V0":
                        vo.setDeviceCode(value);
                        break;
                    case "V1":
                        vo.setControlMode(Integer.parseInt(value));
                        break;
                    case "V2":
                        vo.setOverallCompTemp(Integer.parseInt(value));
                        break;
                    case "V3":
                        vo.setIndividualCompTemp(Integer.parseInt(value));
                        break;
                    case "V4":
                        vo.setClimateCompCoefficient(Integer.parseInt(value));
                        break;
                    case "V5":
                        vo.setOutdoorTemp(Integer.parseInt(value));
                        break;
                    case "V6":
                        vo.setTargetValue(Integer.parseInt(value));
                        break;
                    case "V7":
                        vo.setActualValue(Integer.parseInt(value));
                        break;
                    case "V8":
                        vo.setValveOpening(Integer.parseInt(value));
                        break;
                    case "V9":
                        vo.setEnteringWaterTemp(Integer.parseInt(value));
                        break;
                    case "V10":
                        vo.setReturnWaterTemp(Integer.parseInt(value));
                        break;
                    case "V11":
                        vo.setEnteringWaterPress(Integer.parseInt(value));
                        break;
                    case "V12":
                        vo.setReturnWaterPress(Integer.parseInt(value));
                        break;
                    case "V13":
                        vo.setBatteryVoltage(Integer.parseInt(value));
                        break;
                    case "V14":
                        vo.setGeneratingVoltage(Integer.parseInt(value));
                        break;
                    case "V15":
                        vo.setModeStatus(Integer.parseInt(value));
                        break;
                    case "V16":
                        vo.setFlow(Integer.parseInt(value));
                        break;
                    case "V17":
                        vo.setWaterPressDiffer(Integer.parseInt(value));
                        break;
                    case "V18":
                        vo.setTotalHeat(Integer.parseInt(value));
                        break;
                    default:
                        break;
                }
            }

            vo.setAt(item.getAt());
            vo.setDevId(item.getDev_id());
            vo.setImei(item.getImei());
            vo.setType(item.getType());
            vo.setDsId(item.getDs_id());
            operationMapper.saveOperationHistory(vo);
            // 更新当前运行数据
            OperationControl operationControl = operationMapper.getOperationControl(vo.getImei());
            if (operationControl != null) {
                if (operationControl.getControlMode() != vo.getControlMode() ||
                        operationControl.getTargetValue() != vo.getTargetValue() ||
                        operationControl.getOverallCompTemp() != vo.getOverallCompTemp() ||
                        operationControl.getIndividualCompTemp() != vo.getIndividualCompTemp() ||
                        operationControl.getClimateCompCoefficient() != vo.getClimateCompCoefficient() ||
                        operationControl.getOutdoorTemp() != vo.getOutdoorTemp()) {
                    //下发成功
                    operationMapper.updateOperationPutDownStatus(vo.getImei());

                }
                operationMapper.updateOperation(vo);
            } else {
                operationMapper.saveOperation(vo);
            }

            // 更新设备状态 未连接
            if (StringUtils.isEmpty(vo.getDeviceCode())) {
                deviceManagerMapper.updateDeviceStatus(vo.getImei(), 2);
            } else {
                deviceManagerMapper.updateDeviceStatus(vo.getImei(), 1);
            }

        }


    }

    /**
     * 写资源
     * @param dto
     */
    @Override
    public ResultBody putDownRes(OneNetPutDownDTO dto) {
        ResultBody result = new ResultBody();

        DeviceManagerVo device = deviceManagerMapper.getDeviceByImei(dto.getImei());
        if (device == null) {
            result.setCode(400);
            result.setMessage("设备缺少imei");
            result.setMessageToUser("设备缺少imei");
            return result;
        }
        SysParameterVo sysParameter = sysParameterMapper.getSysParameter(device.getCompanyId());
        if (sysParameter != null && sysParameter.getWorkMode() == 1 && dto.getWorkMode() == 2) {
            result.setCode(400);
            result.setMessage("请切换到云组态控制模式");
            result.setMessageToUser("请切换到云组态控制模式");
            return result;
        }

        if (sysParameter != null && sysParameter.getWorkMode() == 2 && dto.getWorkMode() == 1) {
            result.setCode(400);
            result.setMessage("请切换到组态控制模式");
            result.setMessageToUser("请切换到组态控制模式");
            return result;
        }

        // 记录下发时间，以便判断是否下发超时
        operationMapper.updateOperationPutDownTime(dto.getImei());
        // Write
        JSONObject jsonObject = new JSONObject();
        String val = "";
        for (OneNetPutDownResDTO item : dto.getOneNetPutDownResList()) {
            if (StringUtils.isEmpty(item.getVal())) {
                continue;
            }
            val = val + ValueType.getEnumByKey(item.getResId()) + ":" + item.getVal() + ";";


        }
        org.json.JSONArray jsonArray = new org.json.JSONArray();
        WriteOpe writeOpe = new WriteOpe(apiKey);
        String expiredTime = DateUtil.format(DateUtil.addMinute(new Date(), 5), "yyyy-MM-dd HH:mm:ss").replace(" ","T");
        WriteOffline write = new WriteOffline(dto.getImei(), dto.getObjId(), dto.getObjInstId(), mode,expiredTime);
        jsonObject.put("res_id", 6000);
        jsonObject.put("val", val);
        jsonArray.put(jsonObject);
        JSONObject data = new JSONObject();
        data.put("data", jsonArray);
        logger.info(dto.getImei() + "_" + dto.getObjId() + "_" + dto.getObjInstId() + ":" + jsonArray);
        writeOpe.operation(write, data, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logger.info(dto.getImei() + "_" + dto.getObjId() + "_" + dto.getObjInstId() + "下发异常");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                logger.info(dto.getImei() + "_" + dto.getObjId() + "_" + dto.getObjInstId() + "下发结果:" + response.message());
            }
        });
        return result;
    }

    /**
     * 查询定时任务列表
     * @return
     * @param dto
     */
    @Override
    public List<OperationScheduleVo> listOperationSchedule(OperationScheduleQueryDTO dto) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        if (sysUser.getUserOrigin() == 2) {
            dto.setCompanyId(sysUser.getCompanyId());
        }
        List<OperationScheduleVo> list = operationMapper.listOperationSchedule(dto);

        // 查询参与定时任务设备
        for (OperationScheduleVo item : list) {
            List<OperationScheduleDeviceVo> deviceList = operationMapper.listOperationScheduleDevice(item.getId());
            item.setDeviceList(deviceList);
        }
        return list;
    }

    /**
     * 新增定时任务
     * @param dto 请求参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveOperationSchedule(OperationScheduleDTO dto) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if (sysUser.getUserOrigin() == 2) {
            dto.setCompanyId(sysUser.getCompanyId());
        }
        OperationScheduleVo operationSchedule = operationMapper.getOperationScheduleByScheduleName(dto.getScheduleName(), dto.getCompanyId());
        // 任务名称已存在
        if (operationSchedule != null) {
            return 1;
        }

        operationMapper.saveOperationSchedule(dto);

        // 批量创建定时任务关联设备
        List<OperationScheduleDevice> deviceList = new ArrayList<OperationScheduleDevice>();

        for (String item : dto.getDeviceList()) {
            OperationScheduleDevice device = new OperationScheduleDevice();
            device.setDeviceCode(item);
            device.setScheduleId(dto.getId());
            deviceList.add(device);
        }

        operationMapper.saveOperationScheduleDevice(deviceList);

        // 创建系统定时任务
        SysTask sysTask = new SysTask();
        if (dto.getIsRepeat() != null && dto.getIsRepeat() == 1) {
            // 定时重复，按周重复定时
            String times = DateUtil.format(dto.getScheduleTime(), "HH:mm");
            sysTask.setCronExpression(DateUtil.getCronWeeks(times, dto.getWeeks()));
            sysTask.setJobTime(DateUtil.addYear(new Date(), 50));
        } else {
            // 定时不重复
            sysTask.setCronExpression(DateUtil.getCron(dto.getScheduleTime()));
            sysTask.setJobTime(dto.getScheduleTime());
        }

        sysTask.setDescription(dto.getScheduleName());
        sysTask.setJobGroup(String.valueOf(dto.getId()));
        sysTask.setJobName(dto.getScheduleName());
        sysTask.setJobStatus(1);
        sysTask.setBeanClass("com.hp.server.quartz.JobMethod");

        sysTask.setScheduleId(dto.getId());
        sysTaskMapper.saveSysTask(sysTask);

        // 添加任务
        quartzManager.addJob(sysTask);

        return 0;
    }

    /**
     * 定时任务执行命令下发
     * @param scheduleId
     */
    @Override
    public void putDownSchedule(String scheduleId) {
        List<OperationScheduleDeviceVo> deviceList = operationMapper.listOperationScheduleDevice(Long.valueOf(scheduleId));

        // 定时批量写资源
        for (OperationScheduleDeviceVo item : deviceList) {
            OneNetPutDownDTO dto = new OneNetPutDownDTO();
            // 获取当前运行设备信息
            OperationControl operationControl = operationMapper.getOperationControlByDeviceCode(item.getDeviceCode());
            if (operationControl != null) {
                dto.setImei(operationControl.getImei());
                dto.setObjId(Integer.parseInt(operationControl.getDsId().split("_")[0]));
                dto.setObjInstId(Integer.parseInt(operationControl.getDsId().split("_")[1]));

                // 资源指令参数封装
                ArrayList<OneNetPutDownResDTO> oneNetPutDownResList = new ArrayList<OneNetPutDownResDTO>();
                // 查询定时任务资源参数
                OperationScheduleVo operationSchedule = operationMapper.getOperationSchedule(Long.valueOf(scheduleId));
                OneNetPutDownResDTO oneNetPutDownResDTO1 = new OneNetPutDownResDTO();

                // 控制模式
                oneNetPutDownResDTO1.setResId(6001);
                oneNetPutDownResDTO1.setVal(operationSchedule.getControlMode().toString());
                oneNetPutDownResList.add(oneNetPutDownResDTO1);

                // 平均温度法
                if (operationSchedule.getControlMode() == 1) {
                    // 整体温度补偿
                    OneNetPutDownResDTO oneNetPutDownResDTO2 = new OneNetPutDownResDTO();
                    oneNetPutDownResDTO2.setResId(6002);
                    oneNetPutDownResDTO2.setVal(operationSchedule.getOverallCompTemp().toString());
                    oneNetPutDownResList.add(oneNetPutDownResDTO2);

                    // 个体温度补偿
                    OneNetPutDownResDTO oneNetPutDownResDTO3 = new OneNetPutDownResDTO();
                    oneNetPutDownResDTO3.setResId(6003);
                    oneNetPutDownResDTO3.setVal(operationSchedule.getIndividualCompTemp().toString());
                    oneNetPutDownResList.add(oneNetPutDownResDTO3);

                    // 温度补偿系数
                    OneNetPutDownResDTO oneNetPutDownResDTO4 = new OneNetPutDownResDTO();
                    oneNetPutDownResDTO4.setResId(6004);
                    oneNetPutDownResDTO4.setVal(operationSchedule.getClimateCompCoefficient().toString());
                    oneNetPutDownResList.add(oneNetPutDownResDTO4);

                    // 室外温度
                    OneNetPutDownResDTO oneNetPutDownResDTO5 = new OneNetPutDownResDTO();
                    oneNetPutDownResDTO5.setResId(6005);
                    oneNetPutDownResDTO5.setVal(operationSchedule.getOutdoorTemp().toString());
                    oneNetPutDownResList.add(oneNetPutDownResDTO5);
                } else {
                    // 目标值
                    OneNetPutDownResDTO oneNetPutDownResDTO6 = new OneNetPutDownResDTO();
                    oneNetPutDownResDTO6.setResId(6006);
                    oneNetPutDownResDTO6.setVal(operationSchedule.getTargetValue().toString());
                    oneNetPutDownResList.add(oneNetPutDownResDTO6);
                }

                dto.setOneNetPutDownResList(oneNetPutDownResList);
                putDownRes(dto);
            }

        }
    }

    /**
     * 修改定时任务
     * @param dto 请求参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateOperationSchedule(OperationScheduleDTO dto) throws SchedulerException {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if (sysUser.getUserOrigin() == 2) {
            dto.setCompanyId(sysUser.getCompanyId());
        }

        OperationScheduleVo operationSchedule = operationMapper.getOperationSchedule(dto.getId());
        String oldScheduleName = operationSchedule.getScheduleName();
        String newScheduleName = dto.getScheduleName();

        // 如果修改任务名称，判断任务名称是否已存在
        if (!oldScheduleName.equals(newScheduleName)) {
            OperationScheduleVo operationSchedule1 = operationMapper.getOperationScheduleByScheduleName(newScheduleName, dto.getCompanyId());
            if (operationSchedule1 != null) {
                return 1;
            }
        }

        BeanUtils.copyProperties(dto, operationSchedule);

        operationMapper.updateOperationSchedule(operationSchedule);

        // 删除关联设备
        operationMapper.deleteOperationScheduleDevice(dto.getId());

        // 批量创建定时任务关联设备
        List<OperationScheduleDevice> deviceList = new ArrayList<OperationScheduleDevice>();

        for (String item : dto.getDeviceList()) {
            OperationScheduleDevice device = new OperationScheduleDevice();
            device.setDeviceCode(item);
            device.setScheduleId(dto.getId());
            deviceList.add(device);
        }

        operationMapper.saveOperationScheduleDevice(deviceList);

        // 更新系统定时任务
        SysTask sysTask = new SysTask();
        if (dto.getIsRepeat() != null && dto.getIsRepeat() == 1) {
            // 定时重复，按周重复定时
            String times = DateUtil.format(dto.getScheduleTime(), "HH:mm");
            sysTask.setCronExpression(DateUtil.getCronWeeks(times, dto.getWeeks()));
            sysTask.setJobTime(DateUtil.addYear(new Date(), 50));
        } else {
            // 定时不重复
            sysTask.setCronExpression(DateUtil.getCron(dto.getScheduleTime()));
            sysTask.setJobTime(dto.getScheduleTime());
        }
        sysTask.setDescription(dto.getScheduleName());
        sysTask.setJobGroup(String.valueOf(dto.getId()));
        sysTask.setJobName(dto.getScheduleName());
        sysTask.setJobStatus(1);
        sysTask.setBeanClass("com.hp.server.quartz.JobMethod");
        sysTask.setScheduleId(dto.getId());
        sysTaskMapper.updateSysTask(sysTask);

        // 删除原有job
        quartzManager.deleteJob(sysTask);
        // 新增一个job
        quartzManager.addJob(sysTask);

        return 0;
    }

    /**
     * 根据ID查询定时任务信息
     * @param id 定时任务ID
     * @return
     */
    @Override
    public OperationScheduleVo getOperationSchedule(Long id) {
        OperationScheduleVo vo = operationMapper.getOperationSchedule(id);
        // 查询关联设备
        List<OperationScheduleDeviceVo> deviceList = operationMapper.listOperationScheduleDevice(id);
        vo.setDeviceList(deviceList);
        return vo;
    }

    /**
     * 删除定时任务
     * @param id 定时任务ID
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOperationSchedule(Long id) throws SchedulerException {
        operationMapper.deleteOperationSchedule(id);

        // 删除关联设备
        operationMapper.deleteOperationScheduleDevice(id);

        // 查询系统定时任务
        SysTask sysTask = sysTaskMapper.getSysTask(id);
        // 删除一个job
        quartzManager.deleteJob(sysTask);
        // 删除系统定时任务
        sysTaskMapper.deleteSysTask(id);
    }

    /**
     * 查询表头显示字段列表
     * @return
     */
    @Override
    public List<OperationColumnVo> listOperationColumn() {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        List<OperationColumnVo> list = operationMapper.listOperationColumn(sysUser.getId());
        if (list.size() == 0) {
            list = operationMapper.listOperationColumn(null);
        }
        return list;
    }

    /**
     * 保存表头显示字段设置
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOperationColumn(OperationColumnListDTO dto) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        operationMapper.deleteOperationColumn(sysUser.getId());

        // 批量保存用户表头设置
        for (OperationColumnDTO item : dto.getOperationColumnList()) {
            item.setUserId(sysUser.getId());
        }
        operationMapper.saveOperationColumnBatch(dto.getOperationColumnList());
    }
}
