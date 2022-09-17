package com.hp.server.quartz;

import com.hp.server.service.SysTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author:mengchen
 * @date:2020/5/26
 * @description:
 */
@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {
    @Autowired
    SysTaskService scheduleJobService;

    @Override
    public void run(String... arg0) throws Exception {
        try {
            scheduleJobService.initSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
