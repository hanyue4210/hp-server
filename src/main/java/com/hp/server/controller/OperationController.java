package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.*;
import com.hp.server.result.ResultBody;
import com.hp.server.service.OperationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author:mengchen
 * @date:2020/5/22
 * @description:运行管理
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/operation")
public class OperationController {
    @Resource
    private OperationService operationService;

    /**
     * 根据条件查询控制策略列表
     * @param dto  查询条件
     * @return
     */
    @RequiresPermissions("perm:operation:control")
    @GetMapping(value="/listOperationControl")
    public ResultBody listOperationControl(OperationQueryDTO dto){
        PageInfo pageInfo = new PageInfo<>(operationService.listOperationControl(dto));
        return new ResultBody(pageInfo);
    }

    /**
     * 下发命令
     * @return
     */
    @PostMapping(value="/putDown")
    public ResultBody putDown(@RequestBody OneNetPutDownDTO dto) {
        dto.setWorkMode(2);
        return operationService.putDownRes(dto);
    }

    /**
     * 批量下发命令
     * @return
     */
    @PostMapping(value="/putDownBatch")
    public ResultBody putDownBatch(@RequestBody OneNetPutDownBatchDTO dto) {
        ResultBody result = new ResultBody();
        // Write
        for (OneNetPutDownDTO item : dto.getOneNetPutDownBatchList()) {
            item.setWorkMode(2);
            result = operationService.putDownRes(item);
        }
        return result;
    }

    /**
     * 查询定时任务列表
     * @return
     */
    @RequiresPermissions("perm:operation:schedule")
    @GetMapping(value="/listOperationSchedule")
    public ResultBody listOperationSchedule(OperationScheduleQueryDTO dto){
        PageInfo pageInfo = new PageInfo<>(operationService.listOperationSchedule(dto));
        return new ResultBody(pageInfo);
    }

    /**
     * 新增定时任务
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:operation:schedule:add")
    @PostMapping(value="/saveOperationSchedule")
    public ResultBody saveOperationSchedule(@RequestBody @Valid OperationScheduleDTO dto) {
        ResultBody result = new ResultBody();
        Integer flag = operationService.saveOperationSchedule(dto);
        if (flag != null && flag == 1) {
            result.setCode(400);
            result.setMessage("定时任务名称已存在");
            result.setMessageToUser("定时任务名称已存在");
        }
        return result;
    }

    /**
     * 修改定时任务
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:operation:schedule:update")
    @PostMapping(value="/updateOperationSchedule")
    public ResultBody updateOperationSchedule(@RequestBody @Valid OperationScheduleDTO dto) throws SchedulerException {
        ResultBody result = new ResultBody();
        Integer flag = operationService.updateOperationSchedule(dto);
        if (flag != null && flag == 1) {
            result.setCode(400);
            result.setMessage("定时任务名称已存在");
            result.setMessageToUser("定时任务名称已存在");
        }
        return result;
    }

    /**
     * 根据ID查询定时任务信息
     * @param id 定时任务ID
     * @return
     */
    @RequiresPermissions("perm:operation:schedule")
    @GetMapping(value="/getOperationSchedule")
    public ResultBody getOperationSchedule(Long id) {
        return new ResultBody(operationService.getOperationSchedule(id));
    }

    /**
     * 删除定时任务
     * @param id 定时任务ID
     * @return
     */
    @RequiresPermissions("perm:operation:schedule:delete")
    @GetMapping(value="/deleteOperationSchedule")
    public ResultBody deleteOperationSchedule(Long id) throws SchedulerException {
        ResultBody result = new ResultBody();
        operationService.deleteOperationSchedule(id);
        return result;
    }

    /**
     * 查询表头显示字段列表
     * @return
     */
    @GetMapping(value="/listOperationColumn")
    public ResultBody listOperationColumn() {
        return new ResultBody(operationService.listOperationColumn());
    }

    /**
     * 保存表头显示字段设置
     * @return
     */
    @PostMapping(value="/saveOperationColumn")
    public ResultBody saveOperationColumn(@RequestBody OperationColumnListDTO dto) {
        ResultBody result = new ResultBody();
        operationService.saveOperationColumn(dto);
        return result;
    }
}
