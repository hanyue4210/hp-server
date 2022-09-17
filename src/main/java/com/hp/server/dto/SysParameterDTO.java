package com.hp.server.dto;

import javax.validation.constraints.NotNull;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:参数设置
 */
public class SysParameterDTO {
    private Long id;
    @NotNull(message = "工作模式不能为空！")
    private Integer workMode;
    @NotNull(message = "请求频率不能为空！")
    private Integer requestFrequency;
    private Long companyId;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
