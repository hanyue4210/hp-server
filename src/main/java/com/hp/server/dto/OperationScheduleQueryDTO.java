package com.hp.server.dto;

/**
 * @author:mengchen
 * @date:2020/5/28
 * @description:定时任务列表查询
 */
public class OperationScheduleQueryDTO extends PageDTO{
    private String scheduleName;
    private Long companyId;

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
