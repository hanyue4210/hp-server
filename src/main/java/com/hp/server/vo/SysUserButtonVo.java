package com.hp.server.vo;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:用户按钮权限
 */
public class SysUserButtonVo {
    private Long buttonId;
    private String buttonName;
    // 用户是否拥有按钮权限 1是 0否
    private Integer isOpen;

    public Long getButtonId() {
        return buttonId;
    }

    public void setButtonId(Long buttonId) {
        this.buttonId = buttonId;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }
}
