package com.hp.server.onenet.entity;

import org.json.JSONObject;

/**
 * Created by zhuocongbin
 * date 2018/3/16
 */
public abstract class CommonEntity {
    // 设备imei号，平台唯一，必填参数
    protected String imei;
    // ISPO标准中的Object ID
    protected Integer objId;
    // ISPO标准中的Object Instance ID
    protected Integer objInstId;
    // ISPO标准中的Resource ID
    protected Integer resId;
    // 命令过期时间戳，必填且大于valid_time
    protected String expiredTime;
    public JSONObject toJsonObject(){return null;}
    public abstract String toUrl();
}
