package com.hp.server.dto;

import java.util.Date;

/**
 * @author:mengchen
 * @date:2020/6/30
 * @description:客户档案列表查询条件
 */
public class BasicClientQueryDTO extends PageDTO{
    private String clientCode;
    private String clientName;
    private Date establishTimeStart;
    private Date establishTimeEnd;
    private String province;
    private String city;
    private String district;

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getEstablishTimeStart() {
        return establishTimeStart;
    }

    public void setEstablishTimeStart(Date establishTimeStart) {
        this.establishTimeStart = establishTimeStart;
    }

    public Date getEstablishTimeEnd() {
        return establishTimeEnd;
    }

    public void setEstablishTimeEnd(Date establishTimeEnd) {
        this.establishTimeEnd = establishTimeEnd;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
