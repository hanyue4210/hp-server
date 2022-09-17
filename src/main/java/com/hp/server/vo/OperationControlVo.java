package com.hp.server.vo;

import java.util.Date;

/**
 * @author:mengchen
 * @date:2020/5/22
 * @description:控制策略
 */
public class OperationControlVo {
    private Long id;
    private String deviceCode;
    private String deviceType;
    private String community;
    private String unitInfor;
    private Integer controlMode;
    private Integer targetValue;
    private Integer actualValue;
    private Integer enteringWaterTemp;
    private Integer returnWaterTemp;
    private Integer valveOpening;
    private Integer enteringWaterPress;
    private Integer returnWaterPress;
    private Integer generatingVoltage;
    private Integer batteryVoltage;;
    private Integer overallCompTemp;
    private Integer individualCompTemp;
    private Integer modeStatus;
    private Integer climateCompCoefficient;
    private Integer flow;
    private Integer waterPressDiffer;
    private Integer totalHeat;
    private Integer outdoorTemp;
    private String imei;//nbiot设备的身份码
    private Integer objId;//设备的object id , 对应到平台模型中为数据流id，必填
    private Integer objInstId;//nbiot设备object下具体一个instance的id ，对应到平台模型中数据点key值的一部分，必填

    private String region;
    private String tower;
    private String cell;
    private String groups;
    private String site;
    private String unit;

    private String cellId;
    private String unitId;
    private String regionId;
    private String towerId;
    private String groupId;
    private String siteId;

    private Long communityId;
    private Long unitInforId;

    private Integer putDownStatus;

    private Date updateTime;

    private String modeStatusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getUnitInfor() {
        return unitInfor;
    }

    public void setUnitInfor(String unitInfor) {
        this.unitInfor = unitInfor;
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

    public Integer getActualValue() {
        return actualValue;
    }

    public void setActualValue(Integer actualValue) {
        this.actualValue = actualValue;
    }

    public Integer getEnteringWaterTemp() {
        return enteringWaterTemp;
    }

    public void setEnteringWaterTemp(Integer enteringWaterTemp) {
        this.enteringWaterTemp = enteringWaterTemp;
    }

    public Integer getReturnWaterTemp() {
        return returnWaterTemp;
    }

    public void setReturnWaterTemp(Integer returnWaterTemp) {
        this.returnWaterTemp = returnWaterTemp;
    }

    public Integer getValveOpening() {
        return valveOpening;
    }

    public void setValveOpening(Integer valveOpening) {
        this.valveOpening = valveOpening;
    }

    public Integer getEnteringWaterPress() {
        return enteringWaterPress;
    }

    public void setEnteringWaterPress(Integer enteringWaterPress) {
        this.enteringWaterPress = enteringWaterPress;
    }

    public Integer getReturnWaterPress() {
        return returnWaterPress;
    }

    public void setReturnWaterPress(Integer returnWaterPress) {
        this.returnWaterPress = returnWaterPress;
    }

    public Integer getGeneratingVoltage() {
        return generatingVoltage;
    }

    public void setGeneratingVoltage(Integer generatingVoltage) {
        this.generatingVoltage = generatingVoltage;
    }

    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
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

    public Integer getModeStatus() {
        return modeStatus;
    }

    public void setModeStatus(Integer modeStatus) {
        this.modeStatus = modeStatus;
    }

    public Integer getClimateCompCoefficient() {
        return climateCompCoefficient;
    }

    public void setClimateCompCoefficient(Integer climateCompCoefficient) {
        this.climateCompCoefficient = climateCompCoefficient;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    public Integer getWaterPressDiffer() {
        return waterPressDiffer;
    }

    public void setWaterPressDiffer(Integer waterPressDiffer) {
        this.waterPressDiffer = waterPressDiffer;
    }

    public Integer getTotalHeat() {
        return totalHeat;
    }

    public void setTotalHeat(Integer totalHeat) {
        this.totalHeat = totalHeat;
    }

    public Integer getOutdoorTemp() {
        return outdoorTemp;
    }

    public void setOutdoorTemp(Integer outdoorTemp) {
        this.outdoorTemp = outdoorTemp;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getObjInstId() {
        return objInstId;
    }

    public void setObjInstId(Integer objInstId) {
        this.objInstId = objInstId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getUnitInforId() {
        return unitInforId;
    }

    public void setUnitInforId(Long unitInforId) {
        this.unitInforId = unitInforId;
    }

    public Integer getPutDownStatus() {
        return putDownStatus;
    }

    public void setPutDownStatus(Integer putDownStatus) {
        this.putDownStatus = putDownStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getModeStatusName() {
        return modeStatusName;
    }

    public void setModeStatusName(String modeStatusName) {
        this.modeStatusName = modeStatusName;
    }
}
