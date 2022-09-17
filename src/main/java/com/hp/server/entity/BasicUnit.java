package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BasicUnit {
    private Long id;
    private Long siteId;
    private Long companyId;
    private String unit;
    private Date createTime;
    private String factory;
    private String type;
    private String power;
    private String diameter1;
    private String diameter2;
    private String plateArea;
    private String exchangeRate;
    private String regionDescribe;

}
