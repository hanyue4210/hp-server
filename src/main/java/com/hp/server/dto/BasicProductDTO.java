package com.hp.server.dto;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:06
 */
public class BasicProductDTO extends PageDTO{
    private Integer id;
    private Integer companyId;
    private String productType;
    private String remarks;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "BasicProductDTO{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", productType='" + productType + '\'' +
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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
