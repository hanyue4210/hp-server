package com.hp.server.dto;

import java.util.Date;

public class BasicTowerDTO extends PageDTO {

    private Long id;
    private Long regionId;
    private String region;
    private String tower;
    private Long companyId;
    private Date createTime;

    @Override
    public String toString() {
        return "BasicTowerDTO{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", region='" + region + '\'' +
                ", tower='" + tower + '\'' +
                ", companyId=" + companyId +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
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
}
