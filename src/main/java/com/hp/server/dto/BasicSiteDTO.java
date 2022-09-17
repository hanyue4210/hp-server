package com.hp.server.dto;

import java.util.Date;

public class BasicSiteDTO extends PageDTO {

    private Long id;
    private Long groupId;
    private Long companyId;
    private String site;
    private String groups;
    private Date createTime;

    @Override
    public String toString() {
        return "BasicSiteDTO{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", companyId=" + companyId +
                ", site='" + site + '\'' +
                ", groups='" + groups + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
