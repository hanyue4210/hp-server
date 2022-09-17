package com.hp.server.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/25
 * @description:权限设置
 */
public class SysAuthDTO {
    @NotNull(message = "用户ID不能为空！")
    private Long userId;
    private List<Long> menuList;
    private List<Long> buttonList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Long> menuList) {
        this.menuList = menuList;
    }

    public List<Long> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<Long> buttonList) {
        this.buttonList = buttonList;
    }
}
