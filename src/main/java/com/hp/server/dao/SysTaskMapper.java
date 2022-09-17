package com.hp.server.dao;

import com.hp.server.entity.SysTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/26
 * @description:
 */
@Mapper
public interface SysTaskMapper {
    /**
     * 查询定时任务
     * @return
     */
    List<SysTask> listSysTask();
    /**
     * 创建系统定时任务
     * @param sysTask
     */
    void saveSysTask(SysTask sysTask);

    /**
     * 更新系统定时任务
     * @param sysTask
     */
    void updateSysTask(SysTask sysTask);

    /**
     * 删除系统定时任务
     * @param id
     */
    void deleteSysTask(Long id);

    /**
     * 查询系统定时任务
     * @param id
     * @return
     */
    SysTask getSysTask(Long id);
}
