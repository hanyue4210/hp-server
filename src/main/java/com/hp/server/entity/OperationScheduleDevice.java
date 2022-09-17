package com.hp.server.entity;

import java.util.Date;

/**
 * @author:mengchen
 * @date:2020/5/27
 * @description:定时任务关联设备
 */
public class OperationScheduleDevice {
    private Long id;
    private Long scheduleId;
    private String deviceCode;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
