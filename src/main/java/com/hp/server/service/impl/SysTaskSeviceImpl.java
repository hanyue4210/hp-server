package com.hp.server.service.impl;

import com.hp.server.dao.SysTaskMapper;
import com.hp.server.entity.SysTask;
import com.hp.server.service.SysTaskService;
import com.hp.server.quartz.QuartzManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/26
 * @description:
 */
@Service
public class SysTaskSeviceImpl implements SysTaskService {
    @Resource
    private SysTaskMapper sysTaskMapper;
    @Resource
    private QuartzManager quartzManager;
    @Override
    public void initSchedule() {
        // 这里获取任务信息数据
        List<SysTask> jobList = sysTaskMapper.listSysTask();
        for (SysTask task : jobList) {
            if (task.getJobStatus() == 1 && task.getJobTime().after(new Date())) {
                quartzManager.addJob(task);
            }
        }
    }
}
