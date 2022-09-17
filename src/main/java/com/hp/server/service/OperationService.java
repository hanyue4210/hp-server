package com.hp.server.service;

import com.hp.server.dto.*;
import com.hp.server.result.ResultBody;
import com.hp.server.vo.OneNetReceiveVo;
import com.hp.server.vo.OperationColumnVo;
import com.hp.server.vo.OperationControlVo;
import com.hp.server.vo.OperationScheduleVo;
import org.quartz.SchedulerException;

import java.util.List;

public interface OperationService {
    /**
     * 根据条件查询控制策略列表
     * @param dto  查询条件
     * @return
     */
    List<OperationControlVo> listOperationControl(OperationQueryDTO dto);

    /**
     * 向服务器插入oneNet接收到的数据
     * @param receiveList oneNet数据列表
     */
    void saveOperation(List<OneNetReceiveVo> receiveList);

    /**
     * 写资源
     * @param dto
     */
    ResultBody putDownRes(OneNetPutDownDTO dto);

    /**
     * 查询定时任务列表
     * @return
     * @param dto
     */
    List<OperationScheduleVo> listOperationSchedule(OperationScheduleQueryDTO dto);

    /**
     * 新增定时任务
     * @param dto 请求参数
     * @return
     */
    Integer saveOperationSchedule(OperationScheduleDTO dto);

    /**
     * 定时任务执行命令下发
     * @param scheduleId
     */
    void putDownSchedule(String scheduleId);

    /**
     * 修改定时任务
     * @param dto 请求参数
     * @return
     */
    Integer updateOperationSchedule(OperationScheduleDTO dto) throws SchedulerException;

    /**
     * 根据ID查询定时任务信息
     * @param id 定时任务ID
     * @return
     */
    OperationScheduleVo getOperationSchedule(Long id);

    /**
     * 删除定时任务
     * @param id 定时任务ID
     * @return
     */
    void deleteOperationSchedule(Long id) throws SchedulerException;

    /**
     * 查询表头显示字段列表
     * @return
     */
    List<OperationColumnVo> listOperationColumn();

    /**
     * 保存表头显示字段设置
     * @return
     */
    void saveOperationColumn(OperationColumnListDTO dto);
}
