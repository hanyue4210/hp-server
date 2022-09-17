package com.hp.server.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:修改密码
 */
public class PasswordDTO {
    @NotBlank(message = "旧密码不能为空！")
    private String oldPassword;
    @NotBlank(message = "新密码不能为空！")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
