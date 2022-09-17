package com.hp.server.dto;

/**
 * @author:mengchen
 * @date:2020/5/27
 * @description:
 */
public class OneNetPutDownResDTO {
    private Integer resId; //指定write操作的资源id
    private String val; //根据指定资源的类型决定val的数值类型，可为boolean、string、long、double

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
