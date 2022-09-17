package com.hp.server.dto;

/**
 * @author:mengchen
 * @date:2020/6/29
 * @description:
 */
public class ModbusAdapterWriteDTO {
    private String deviceCode;
    private Integer resId;
    private Integer resValue;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getResValue() {
        return resValue;
    }

    public void setResValue(Integer resValue) {
        this.resValue = resValue;
    }
}
