package com.hp.server.dao;

import com.hp.server.dto.OperationColumnDTO;
import com.hp.server.dto.OperationQueryDTO;
import com.hp.server.dto.OperationScheduleDTO;
import com.hp.server.dto.OperationScheduleQueryDTO;
import com.hp.server.entity.OperationScheduleDevice;
import com.hp.server.entity.OperationControl;
import com.hp.server.entity.OperationHistory;
import com.hp.server.entity.SysTask;
import com.hp.server.vo.OperationColumnVo;
import com.hp.server.vo.OperationControlVo;
import com.hp.server.vo.OperationScheduleDeviceVo;
import com.hp.server.vo.OperationScheduleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OperationMapper {
    /**
     * 根据条件查询控制策略列表
     * @param dto  查询条件
     * @return
     */
    List<OperationControlVo> listOperationControl(OperationQueryDTO dto);

    /**
     * 保存历史记录
     * @param vo 请求参数
     */
    void saveOperationHistory(OperationHistory vo);

    /**
     * 更新当前运行数据
     * @param vo 请求参数
     */
    void updateOperation(OperationHistory vo);

    /**
     * 根据imei获取当前数据
     * @param imei
     * @return
     */
    OperationControl getOperationControl(String imei);

    /**
     * 保存当前运行数据
     * @param vo
     */
    void saveOperation(OperationHistory vo);

    /**
     * 查询定时任务列表
     * @return
     * @param dto 查询参数
     */
    List<OperationScheduleVo> listOperationSchedule(OperationScheduleQueryDTO dto);

    /**
     * 查询参与定时任务设备
     * @param id 定时任务ID
     * @return
     */
    List<String> listOperationScheduleDeviceName(Long id);

    /**
     * 保存定时任务
     * @param dto
     */
    void saveOperationSchedule(OperationScheduleDTO dto);

    /**
     * 批量创建定时任务关联设备
     * @param deviceList 设备信息列表
     */
    void saveOperationScheduleDevice(List<OperationScheduleDevice> deviceList);

    /**
     * 查询定时任务关联设备
     * @param scheduleId 定时任务ID
     * @return
     */
    List<OperationScheduleDeviceVo> listOperationScheduleDevice(Long scheduleId);

    /**
     * 根据设备串码查询设备运行信息
     * @param deviceCode 设备串码
     * @return
     */
    OperationControl getOperationControlByDeviceCode(String deviceCode);

    /**
     * 查询定时任务资源参数
     * @param scheduleId 定时任务ID
     * @return
     */
    OperationScheduleVo getOperationSchedule(Long scheduleId);

    /**
     * 修改定时任务
     * @param dto 请求参数
     * @return
     */
    void updateOperationSchedule(OperationScheduleVo dto);

    /**
     * 删除关联设备
     * @param id 定时任务ID
     */
    void deleteOperationScheduleDevice(Long id);

    /**
     * 删除定时任务
     * @param id 定时任务ID
     * @return
     */
    void deleteOperationSchedule(Long id);

    /**
     * 更新下发时间
     * @param imei
     */
    void updateOperationPutDownTime(String imei);

    /**
     * 更新下发状态
     * @param imei
     */
    void updateOperationPutDownStatus(String imei);

    /**
     * 查询表头显示字段列表
     * @param userId 用户ID
     * @return
     */
    List<OperationColumnVo> listOperationColumn(@Param("userId") Long userId);

    /**
     * 删除改用户表头
     * @param userId 用户ID
     */
    void deleteOperationColumn(@Param("userId") Long userId);

    /**
     * 批量添加
     * @param operationColumnList
     */
    void saveOperationColumnBatch(List<OperationColumnDTO> operationColumnList);

    /**
     * 根据定时任务名称查询
     * @param scheduleName 定时任务名称
     * @param companyId 公司ID
     * @return
     */
    OperationScheduleVo getOperationScheduleByScheduleName(@Param("scheduleName") String scheduleName, @Param("companyId") Long companyId);
}
