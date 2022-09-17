package com.hp.server.vo;

import lombok.Data;

@Data
public class OneNetPutDownVo {
    private String imei;//nbiot设备的身份码
    private Integer objId;//设备的object id , 对应到平台模型中为数据流id，必填
    private Integer objInstId;//nbiot设备object下具体一个instance的id ，对应到平台模型中数据点key值的一部分，必填
    private Integer mode;//写的模式（1：replace，2：partial update）
    private String writeResId; //指定write操作的资源id
    private String val; //根据指定资源的类型决定val的数值类型，可为boolean、string、long、double
}
