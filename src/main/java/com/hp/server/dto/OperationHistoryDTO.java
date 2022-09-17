package com.hp.server.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OperationHistoryDTO extends PageDTO{
    private Long id;
    @NotNull(message = "分组不能为空")
    private Integer dataPoint;
    private Long deviceId;
    private String deviceCode;
    private Long controlMode;
    private Long targetValue;
    private Long actualValue;
    private Long enteringWaterTemp;
    private Long returnWaterTemp;
    private Long valveOpening;
    private Long enteringWaterPress;
    private Long returnWaterPress;
    private Long generatingVoltage;
    private Long batteryVoltage;
    private Long overallCompTemp;
    private Long individualCompTemp;
    private Long climateCompCoefficient;
    private Long modeStatus;
    private Long flow;
    private Long waterPressDiffer;
    private Long totalHeat;
    private Long outdoorTemp;
    private Long companyId;
    private Date createTime;
    private Long regionId;
    private Long towerId;
    private Long cellId;
    private Long groupId;
    private Long siteId;
    private Long unitId;
    private String deviceName;
    private Long startTime;
    private Long endTime;

    public Integer getDataPoint() {
        return dataPoint;
    }

    public void setDataPoint(Integer dataPoint) {
        this.dataPoint = dataPoint;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getTowerId() {
        return towerId;
    }

    public void setTowerId(Long towerId) {
        this.towerId = towerId;
    }

    public Long getCellId() {
        return cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Long getControlMode() {
        return controlMode;
    }

    public void setControlMode(Long controlMode) {
        this.controlMode = controlMode;
    }

    public Long getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Long targetValue) {
        this.targetValue = targetValue;
    }

    public Long getActualValue() {
        return actualValue;
    }

    public void setActualValue(Long actualValue) {
        this.actualValue = actualValue;
    }

    public Long getEnteringWaterTemp() {
        return enteringWaterTemp;
    }

    public void setEnteringWaterTemp(Long enteringWaterTemp) {
        this.enteringWaterTemp = enteringWaterTemp;
    }

    public Long getReturnWaterTemp() {
        return returnWaterTemp;
    }

    public void setReturnWaterTemp(Long returnWaterTemp) {
        this.returnWaterTemp = returnWaterTemp;
    }

    public Long getValveOpening() {
        return valveOpening;
    }

    public void setValveOpening(Long valveOpening) {
        this.valveOpening = valveOpening;
    }

    public Long getEnteringWaterPress() {
        return enteringWaterPress;
    }

    public void setEnteringWaterPress(Long enteringWaterPress) {
        this.enteringWaterPress = enteringWaterPress;
    }

    public Long getReturnWaterPress() {
        return returnWaterPress;
    }

    public void setReturnWaterPress(Long returnWaterPress) {
        this.returnWaterPress = returnWaterPress;
    }

    public Long getGeneratingVoltage() {
        return generatingVoltage;
    }

    public void setGeneratingVoltage(Long generatingVoltage) {
        this.generatingVoltage = generatingVoltage;
    }

    public Long getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Long batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public Long getOverallCompTemp() {
        return overallCompTemp;
    }

    public void setOverallCompTemp(Long overallCompTemp) {
        this.overallCompTemp = overallCompTemp;
    }

    public Long getIndividualCompTemp() {
        return individualCompTemp;
    }

    public void setIndividualCompTemp(Long individualCompTemp) {
        this.individualCompTemp = individualCompTemp;
    }

    public Long getClimateCompCoefficient() {
        return climateCompCoefficient;
    }

    public void setClimateCompCoefficient(Long climateCompCoefficient) {
        this.climateCompCoefficient = climateCompCoefficient;
    }

    public Long getModeStatus() {
        return modeStatus;
    }

    public void setModeStatus(Long modeStatus) {
        this.modeStatus = modeStatus;
    }

    public Long getFlow() {
        return flow;
    }

    public void setFlow(Long flow) {
        this.flow = flow;
    }

    public Long getWaterPressDiffer() {
        return waterPressDiffer;
    }

    public void setWaterPressDiffer(Long waterPressDiffer) {
        this.waterPressDiffer = waterPressDiffer;
    }

    public Long getTotalHeat() {
        return totalHeat;
    }

    public void setTotalHeat(Long totalHeat) {
        this.totalHeat = totalHeat;
    }

    public Long getOutdoorTemp() {
        return outdoorTemp;
    }

    public void setOutdoorTemp(Long outdoorTemp) {
        this.outdoorTemp = outdoorTemp;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OperationHistoryDTO{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", deviceCode='" + deviceCode + '\'' +
                ", controlMode=" + controlMode +
                ", targetValue=" + targetValue +
                ", actualValue=" + actualValue +
                ", enteringWaterTemp=" + enteringWaterTemp +
                ", returnWaterTemp=" + returnWaterTemp +
                ", valveOpening=" + valveOpening +
                ", enteringWaterPress=" + enteringWaterPress +
                ", returnWaterPress=" + returnWaterPress +
                ", generatingVoltage=" + generatingVoltage +
                ", batteryVoltage=" + batteryVoltage +
                ", overallCompTemp=" + overallCompTemp +
                ", individualCompTemp=" + individualCompTemp +
                ", climateCompCoefficient=" + climateCompCoefficient +
                ", modeStatus=" + modeStatus +
                ", flow=" + flow +
                ", waterPressDiffer=" + waterPressDiffer +
                ", totalHeat=" + totalHeat +
                ", outdoorTemp=" + outdoorTemp +
                ", companyId=" + companyId +
                ", createTime=" + createTime +
                ", regionId=" + regionId +
                ", towerId=" + towerId +
                ", cellId=" + cellId +
                ", groupId=" + groupId +
                ", siteId=" + siteId +
                ", unitId=" + unitId +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
