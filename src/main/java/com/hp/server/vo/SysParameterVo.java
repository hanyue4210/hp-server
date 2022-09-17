package com.hp.server.vo;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:参数设置信息
 */
public class SysParameterVo {
    private Long id;
    private Integer workMode;
    private Integer requestFrequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }

    public Integer getRequestFrequency() {
        return requestFrequency;
    }

    public void setRequestFrequency(Integer requestFrequency) {
        this.requestFrequency = requestFrequency;
    }
}
