package com.hp.server.dto;

import java.util.Date;

public class BasicGroupDTO extends PageDTO {

    private Long id;
    private String groups;
    private Long companyId;
    private Date createTime;

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

    public String getGroup() {
        return groups;
    }

    public void setGroup(String group) {
        this.groups = group;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BasicGroupVo{" +
                "id=" + id +
                ", groups='" + groups + '\'' +
                ", companyId=" + companyId +
                ", createTime=" + createTime +
                '}';
    }
}
