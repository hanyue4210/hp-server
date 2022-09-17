package com.hp.server.dto;

import java.util.Date;

public class BasicUnitDTO extends PageDTO {

    private Long id;
    private Long siteId;
    private Long groupId;
    private String unit;
    private String site;
    private String groups;
    private Long companyId;
    private Date createTime;
    private String factory;
    private String type;
    private String power;
    private String diameter1;
    private String diameter2;
    private String plateArea;
    private String exchangeRate;
    private String regionDescribe;

    @Override
    public String toString() {
        return "BasicUnitDTO{" +
                "id=" + id +
                ", siteId=" + siteId +
                ", groupId=" + groupId +
                ", unit='" + unit + '\'' +
                ", site='" + site + '\'' +
                ", groups='" + groups + '\'' +
                ", companyId=" + companyId +
                ", createTime=" + createTime +
                ", factory='" + factory + '\'' +
                ", type='" + type + '\'' +
                ", power='" + power + '\'' +
                ", diameter1='" + diameter1 + '\'' +
                ", diameter2='" + diameter2 + '\'' +
                ", plateArea='" + plateArea + '\'' +
                ", exchangeRate='" + exchangeRate + '\'' +
                ", regionDescribe='" + regionDescribe + '\'' +
                '}';
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDiameter1() {
        return diameter1;
    }

    public void setDiameter1(String diameter1) {
        this.diameter1 = diameter1;
    }

    public String getDiameter2() {
        return diameter2;
    }

    public void setDiameter2(String diameter2) {
        this.diameter2 = diameter2;
    }

    public String getPlateArea() {
        return plateArea;
    }

    public void setPlateArea(String plateArea) {
        this.plateArea = plateArea;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getRegionDescribe() {
        return regionDescribe;
    }

    public void setRegionDescribe(String regionDescribe) {
        this.regionDescribe = regionDescribe;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
