package com.hp.server.entity;

import lombok.Data;

@Data
public class DeviceManager {
    private String id;
    private String deviceCode;
    private String deviceName;
    private String deviceType;
    private String community;
    private String unitInfor;
    private String createTime;
    private String companyId;
    private Integer status;
    private Integer productType;
}
