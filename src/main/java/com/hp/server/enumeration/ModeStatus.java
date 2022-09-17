package com.hp.server.enumeration;

public enum ModeStatus {
    MS1(1, "发电电压异常"),
    MS2(2, "电池故障"),
    MS3(3, "进水温度传感器故障"),
    MS4(4, "回水温度传感器故障"),
    MS5(5, "进水压力传感器故障"),
    MS6(6, "回水压力传感器故障"),
    MS7(7, "/"),
    MS8(8, "LORA通讯异常"),
    MS9(9, "NB通讯异常"),
    MS10(10, "485通讯异常"),
    MS11(11, "以太网通讯异常"),
    MS12(12, "/"),
    MS13(13, "/"),
    MS14(14, "故障运行"),
    MS15(15, "正常运行");

    // 成员变量
    private Integer code;
    private String msg;

    // 构造方法
    private ModeStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //根据key获取枚举
    public static ModeStatus getEnumByKey(Integer code){
        if(code == null){
            return null;
        }
        for(ModeStatus temp:ModeStatus.values()){
            if(temp.code.equals(code)){
                return temp;
            }
        }
        return null;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
