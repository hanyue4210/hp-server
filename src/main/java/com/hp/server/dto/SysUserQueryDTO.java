package com.hp.server.dto;

/**
 * @author:mengchen
 * @date:2020/5/20
 * @description:用户列表查询参数
 */
public class SysUserQueryDTO extends PageDTO {
    private String userName;
    private Integer userType;
    private String menuIds;
    private Long companyId;
    private Integer userOrigin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Integer getUserOrigin() {
        return userOrigin;
    }

    public void setUserOrigin(Integer userOrigin) {
        this.userOrigin = userOrigin;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
