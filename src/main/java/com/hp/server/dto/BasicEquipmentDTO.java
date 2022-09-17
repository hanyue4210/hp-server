package com.hp.server.dto;

/**
 * @author hanyue
 * @create 2020-06-29 上午 09:57
 */
public class BasicEquipmentDTO extends PageDTO {
    private Integer id;
    private Integer companyId;
    private String equipmentType;
    private String equipmentClass;
    private String remarks;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "BasicEquipmentDTO{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", equipmentType='" + equipmentType + '\'' +
                ", equipmentClass='" + equipmentClass + '\'' +
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentClass() {
        return equipmentClass;
    }

    public void setEquipmentClass(String equipmentClass) {
        this.equipmentClass = equipmentClass;
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
