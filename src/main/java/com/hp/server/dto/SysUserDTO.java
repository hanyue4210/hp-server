package com.hp.server.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author:mengchen
 * @date:2020/5/20
 * @description:系统用户
 */
public class SysUserDTO {
    private Long id;
    @NotBlank(message = "用户名不能为空！")
    private String loginName;
    private String password;
    @NotBlank(message = "用户姓名不能为空！")
    private String userName;
    @NotBlank(message = "手机号不能为空！")
    private String mobile;
    @NotNull(message = "用户类型不能为空！")
    private Integer userType;
    private Long companyId;
    private Integer userOrigin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getUserOrigin() {
        return userOrigin;
    }

    public void setUserOrigin(Integer userOrigin) {
        this.userOrigin = userOrigin;
    }
}
