package com.hp.server.service.impl;

import com.hp.server.dao.OperationMapper;
import com.hp.server.dao.SysParameterMapper;
import com.hp.server.dao.SysUserMapper;
import com.hp.server.dto.ModbusAdapterWriteDTO;
import com.hp.server.dto.OneNetPutDownDTO;
import com.hp.server.dto.OneNetPutDownResDTO;
import com.hp.server.entity.OperationControl;
import com.hp.server.entity.SysUser;
import com.hp.server.result.ResultBody;
import com.hp.server.service.ModbusAdapterService;
import com.hp.server.service.OperationService;
import com.hp.server.vo.SysParameterVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/6/29
 * @description:
 */
@Service
public class ModbusAdapterServiceImpl implements ModbusAdapterService {
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private OperationService operationService;
    @Resource
    private SysParameterMapper sysParameterMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 读数据点：根据设备串码和属性id读取设备的某一个属性的最新值
     *
     * @param deviceCode 设备串码
     * @param resId      属性ID
     * @return
     */
    @Override
    public Integer readResource(String deviceCode, Integer resId) {
        Integer resValue = null;
        OperationControl operationControl = operationMapper.getOperationControlByDeviceCode(deviceCode);
        if (operationControl != null) {
            switch (resId){
                case 6001:
                    resValue = operationControl.getControlMode();
                    break;
                case 6002:
                    resValue = operationControl.getOverallCompTemp();
                    break;
                case 6003:
                    resValue = operationControl.getIndividualCompTemp();
                    break;
                case 6004:
                    resValue = operationControl.getClimateCompCoefficient();
                    break;
                case 6005:
                    resValue = operationControl.getOutdoorTemp();
                    break;
                case 6006:
                    resValue = operationControl.getTargetValue();
                    break;
                case 6007:
                    resValue = operationControl.getActualValue();
                    break;
                case 6008:
                    resValue = operationControl.getValveOpening();
                    break;
                case 6009:
                    resValue = operationControl.getEnteringWaterTemp();
                    break;
                case 6010:
                    resValue = operationControl.getReturnWaterTemp();
                    break;
                case 6011:
                    resValue = operationControl.getEnteringWaterPress();
                    break;
                case 6012:
                    resValue = operationControl.getReturnWaterPress();
                    break;
                case 6013:
                    resValue = operationControl.getBatteryVoltage();
                    break;
                case 6014:
                    resValue = operationControl.getGeneratingVoltage();
                    break;
                case 6015:
                    resValue = operationControl.getModeStatus();
                    break;
                case 6016:
                    resValue = operationControl.getFlow();
                    break;
                case 6017:
                    resValue = operationControl.getWaterPressDiffer();
                    break;
                case 6018:
                    resValue = operationControl.getTotalHeat();
                    break;
                default:
                    break;
            }
        }

        return resValue;
    }

    /**
     * 写数据点：根据设备串码和属性id向设备的某一个属性写入新的数据
     *
     * @param dto 请求参数
     * @return
     */
    @Override
    public ResultBody writeResource(ModbusAdapterWriteDTO dto) {
        ResultBody result = new ResultBody();

        OneNetPutDownDTO res = new OneNetPutDownDTO();
        OperationControl operationControl = operationMapper.getOperationControlByDeviceCode(dto.getDeviceCode());
        if (operationControl != null) {
            // 封装向OneNet下发数据参数
            res.setWorkMode(1);//组件控制模式
            res.setImei(operationControl.getImei());
            res.setObjId(Integer.parseInt(operationControl.getDsId().split("_")[0]));
            res.setObjInstId(Integer.parseInt(operationControl.getDsId().split("_")[1]));

            List<OneNetPutDownResDTO> list = new ArrayList<OneNetPutDownResDTO>();
            OneNetPutDownResDTO resSub = new OneNetPutDownResDTO();
            resSub.setResId(dto.getResId());
            resSub.setVal(dto.getResValue().toString());

            list.add(resSub);
            res.setOneNetPutDownResList(list);

            return operationService.putDownRes(res);
        } else {
            result.setCode(400);
            result.setMessage("设备缺少运行参数");
            result.setMessageToUser("设备缺少运行参数");
            return result;
        }

    }

    /**
     * 查询请求频率
     *
     * @param loginName 用户名
     * @return
     */
    @Override
    public ResultBody getRequestFrequency(String loginName) {
        ResultBody result = new ResultBody();

        // 根据用户名查询用户信息
        SysUser sysUser = sysUserMapper.findByLoginName(loginName);
        SysParameterVo sysParameter = sysParameterMapper.getSysParameter(sysUser.getCompanyId());

        if (sysParameter != null && sysParameter.getWorkMode() == 1) {
            result.setData(sysParameter.getRequestFrequency());

        } else {
            result.setCode(400);
            result.setMessage("请查看参数设置是否正确");
            result.setMessageToUser("请查看参数设置是否正确");
        }
        return result;
    }
}
