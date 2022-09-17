package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OperationHistory {
    private Long id;
    private Long deviceId;
    private String deviceCode;
    private Integer controlMode;
    private Integer targetValue;
    private Integer actualValue;
    private Integer enteringWaterTemp;
    private Integer returnWaterTemp;
    private Integer valveOpening;
    private Integer enteringWaterPress;
    private Integer returnWaterPress;
    private Integer generatingVoltage;
    private Integer batteryVoltage;
    private Integer overallCompTemp;
    private Integer individualCompTemp;
    private Integer climateCompCoefficient;
    private Integer modeStatus;
    private Integer flow;
    private Integer waterPressDiffer;
    private Integer totalHeat;
    private Integer outdoorTemp;
    private Date createTime;
    private Long at;
    private String imei;
    private Integer type;
    private String dsId;
    private Long devId;


}
