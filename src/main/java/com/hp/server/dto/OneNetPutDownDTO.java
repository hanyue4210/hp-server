package com.hp.server.dto;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/27
 * @description:指令下发
 */
public class OneNetPutDownDTO {
    private String imei;//nbiot设备的身份码
    private Integer objId;//设备的object id , 对应到平台模型中为数据流id，必填
    private Integer objInstId;//nbiot设备object下具体一个instance的id ，对应到平台模型中数据点key值的一部分，必填
    private Integer mode;//写的模式（1：replace，2：partial update）
    private Integer workMode;

    private List<OneNetPutDownResDTO> oneNetPutDownResList;


    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getObjInstId() {
        return objInstId;
    }

    public void setObjInstId(Integer objInstId) {
        this.objInstId = objInstId;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public List<OneNetPutDownResDTO> getOneNetPutDownResList() {
        return oneNetPutDownResList;
    }

    public void setOneNetPutDownResList(List<OneNetPutDownResDTO> oneNetPutDownResList) {
        this.oneNetPutDownResList = oneNetPutDownResList;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }
}
