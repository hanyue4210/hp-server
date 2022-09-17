package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author:mengchen
 * @date:2020/5/26
 * @description:运行控制
 */
@Data
public class OperationControl {
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
    private String imei;
    private String dsId;
}
