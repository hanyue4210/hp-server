package com.hp.server.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/27
 * @description:
 */
public class OperationScheduleDTO {
    private Long id;
    @NotBlank(message = "定时任务名称不能为空！")
    private String scheduleName;
    @NotNull(message = "定时时间不能为空！")
    private Date scheduleTime;
    private Integer controlMode;
    private Integer targetValue;
    private Integer overallCompTemp;
    private Integer individualCompTemp;
    private Integer climateCompCoefficient;
    private Integer outdoorTemp;
    private Long companyId;
    private List<String> deviceList;
    private Integer isRepeat;
    private String weeks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Integer getControlMode() {
        return controlMode;
    }

    public void setControlMode(Integer controlMode) {
        this.controlMode = controlMode;
    }

    public Integer getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Integer targetValue) {
        this.targetValue = targetValue;
    }

    public Integer getOverallCompTemp() {
        return overallCompTemp;
    }

    public void setOverallCompTemp(Integer overallCompTemp) {
        this.overallCompTemp = overallCompTemp;
    }

    public Integer getIndividualCompTemp() {
        return individualCompTemp;
    }

    public void setIndividualCompTemp(Integer individualCompTemp) {
        this.individualCompTemp = individualCompTemp;
    }

    public Integer getClimateCompCoefficient() {
        return climateCompCoefficient;
    }

    public void setClimateCompCoefficient(Integer climateCompCoefficient) {
        this.climateCompCoefficient = climateCompCoefficient;
    }

    public Integer getOutdoorTemp() {
        return outdoorTemp;
    }

    public void setOutdoorTemp(Integer outdoorTemp) {
        this.outdoorTemp = outdoorTemp;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<String> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<String> deviceList) {
        this.deviceList = deviceList;
    }

    public Integer getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(Integer isRepeat) {
        this.isRepeat = isRepeat;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }
}
