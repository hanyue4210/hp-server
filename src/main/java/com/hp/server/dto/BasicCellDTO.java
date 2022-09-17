package com.hp.server.dto;

import java.util.Date;

public class BasicCellDTO extends PageDTO {

    private Long id;
    private Long towerId;
    private Long regionId;
    private String tower;
    private String region;
    private String cell;
    private Long companyId;
    private Date createTime;

    @Override
    public String toString() {
        return "BasicCellDTO{" +
                "id=" + id +
                ", towerId=" + towerId +
                ", regionId=" + regionId +
                ", tower='" + tower + '\'' +
                ", region='" + region + '\'' +
                ", cell='" + cell + '\'' +
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

    public Long getTowerId() {
        return towerId;
    }

    public void setTowerId(Long towerId) {
        this.towerId = towerId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
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
