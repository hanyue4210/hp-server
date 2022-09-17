package com.hp.server.dto;

/**
 * @author:mengchen
 * @date:2020/5/19
 * @description:用户登录数据
 */
public class SysUserLoginDTO {
    private String loginName;
    private String password;

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
}
