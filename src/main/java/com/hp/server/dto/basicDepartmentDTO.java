package com.hp.server.dto;

import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author hanyue
 * @create 2020-06-28 下午 02:56
 */
public class basicDepartmentDTO extends PageDTO{
    private Integer id;
    private Date createTime;
    private Integer companyId;
    private String departmentName;
    private String managerPeo;
    private String remarks;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "basicDepartmentDTO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", companyId=" + companyId +
                ", departmentName='" + departmentName + '\'' +
                ", managerPeo='" + managerPeo + '\'' +
                ", remarks='" + remarks + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManagerPeo() {
        return managerPeo;
    }

    public void setManagerPeo(String managerPeo) {
        this.managerPeo = managerPeo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
