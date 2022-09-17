package com.hp.server.dto;

/**
 * @author hanyue
 * @create 2020-06-29 下午 03:23
 */
public class ApManagerDTO extends PageDTO{
    private Integer id;
    private Integer companyId;
    private String apCode;
    private String apName;
    private String imei;
    private String imeiCode;
    private String status;
    private String takeStatus;
    private Integer isDeleted;
    private String remarks;

    @Override
    public String toString() {
        return "ApManagerDTO{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", apCode='" + apCode + '\'' +
                ", apName='" + apName + '\'' +
                ", imei='" + imei + '\'' +
                ", imeiCode='" + imeiCode + '\'' +
                ", status='" + status + '\'' +
                ", takeStatus='" + takeStatus + '\'' +
                ", isDeleted=" + isDeleted +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getApCode() {
        return apCode;
    }

    public void setApCode(String apCode) {
        this.apCode = apCode;
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImeiCode() {
        return imeiCode;
    }

    public void setImeiCode(String imeiCode) {
        this.imeiCode = imeiCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTakeStatus() {
        return takeStatus;
    }

    public void setTakeStatus(String takeStatus) {
        this.takeStatus = takeStatus;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
