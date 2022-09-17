package com.hp.server.dto;

import java.util.Date;

public class BasicRegionDTO extends PageDTO {

    private Long id;
    private String region;
    private Long companyId;
    private Date createTime;

    @Override
    public String toString() {
        return "BasicRegionDTO{" +
                "id=" + id +
                ", region='" + region + '\'' +
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
