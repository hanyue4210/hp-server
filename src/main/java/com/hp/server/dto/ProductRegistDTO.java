package com.hp.server.dto;

import java.util.Date;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:35
 */
public class ProductRegistDTO extends PageDTO{
    private Integer id;
    private Date createTime;
    private Integer companyId;
    private String productNum;
    private String deviceCode;
    private String imei;
    private String imsi;
    private String equipmentName;
    private String equipmentType;
    private String productType;
    private String equipmentCode;
    private String productDate;
    private String chenkPeo;
    private String inputDate;
    private String inputPeo;
    private String leaveDate;
    private String remarks;
    private Integer isDeleted;

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

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getChenkPeo() {
        return chenkPeo;
    }

    public void setChenkPeo(String chenkPeo) {
        this.chenkPeo = chenkPeo;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputPeo() {
        return inputPeo;
    }

    public void setInputPeo(String inputPeo) {
        this.inputPeo = inputPeo;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
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

    @Override
    public String toString() {
        return "ProductRegistDTO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", companyId=" + companyId +
                ", productNum='" + productNum + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", imei='" + imei + '\'' +
                ", imsi='" + imsi + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", productType='" + productType + '\'' +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", productDate='" + productDate + '\'' +
                ", chenkPeo='" + chenkPeo + '\'' +
                ", inputDate='" + inputDate + '\'' +
                ", inputPeo='" + inputPeo + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", remarks='" + remarks + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
