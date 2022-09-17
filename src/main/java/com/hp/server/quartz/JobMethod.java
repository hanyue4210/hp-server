package com.hp.server.quartz;

import com.hp.server.service.OperationService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author:mengchen
 * @date:2020/5/27
 * @description:
 */
@Configuration
public class JobMethod implements Job {
    private static Logger logger = LoggerFactory.getLogger(JobMethod.class);
    @Resource
    private OperationService operationService;

    public JobMethod() {

    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        String scheduleId = context.getJobDetail().getKey().getGroup();
        logger.info(scheduleId);
        logger.info("Job执行时间: " + new Date());

        // 执行命令下发
        operationService.putDownSchedule(scheduleId);

    }
}
