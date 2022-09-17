package com.hp.server.onenet.entity;

import com.hp.server.onenet.config.Config;

/**
 * @author:mengchen
 * @date:2020/5/29
 * @description:
 */
public class WriteOffline extends CommonEntity{
    private Integer mode;

    /**
     * @param imei 设备IMEI
     * @param objId 写对象ID
     * @param objInstId 写实例ID
     * @param mode 写的模式（1：replace，2：partial update）
     */
    public WriteOffline(String imei, Integer objId, Integer objInstId, Integer mode, String expiredTime) {
        this.imei = imei;
        this.objId = objId;
        this.objInstId = objInstId;
        this.mode = mode;
        this.expiredTime = expiredTime;
    }
    public String toUrl() {
        StringBuilder url = new StringBuilder(Config.getDomainName());
        url.append("/nbiot/offline?imei=").append(this.imei);
        url.append("&obj_id=").append(this.objId);
        url.append("&obj_inst_id=").append(this.objInstId);
        url.append("&mode=").append(this.mode);
        url.append("&expired_time=").append(this.expiredTime);
        return url.toString();
    }
}
