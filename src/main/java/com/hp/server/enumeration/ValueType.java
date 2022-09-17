package com.hp.server.enumeration;

public enum ValueType {
    V1(6001, "V1"),
    V2(6002, "V2"),
    V3(6003, "V3"),
    V4(6004, "V4"),
    V5(6005, "V5"),
    V6(6006, "V6");

    // 成员变量
    private Integer code;
    private String msg;

    // 构造方法
    private ValueType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //根据key获取枚举
    public static ValueType getEnumByKey(Integer code){
        if(code == null){
            return null;
        }
        for(ValueType temp:ValueType.values()){
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
