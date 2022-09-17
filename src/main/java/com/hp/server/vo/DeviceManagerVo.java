package com.hp.server.vo;

import lombok.Data;

@Data
public class DeviceManagerVo {
    private Long id;
    private String deviceCode;
    private String deviceName;
    private String deviceType;
    private String community;
    private String unitInfor;
    private Long communityId;
    private Long unitInforId;
    private String createTime;
    private Long companyId;
    private Integer status;

    private String cellId;
    private String unitId;
    private String regionId;
    private String towerId;
    private String groupId;
    private String siteId;

    private String region;
    private String tower;
    private String cell;
    private String groups;
    private String site;
    private String unit;
    private Integer productType;

    private String apCode;
}
