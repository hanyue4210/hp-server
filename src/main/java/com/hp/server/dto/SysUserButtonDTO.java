package com.hp.server.dto;

import com.hp.server.entity.SysUserButton;
import com.hp.server.vo.SysUserButtonVo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:设置用户按钮权限
 */
public class SysUserButtonDTO {
    @NotNull(message = "用户ID不能为空！")
    private Long userId;
    @NotBlank(message = "菜单Key不能为空！")
    private String menuKey;
    private List<SysUserButtonVo> sysUserButtonVoList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public List<SysUserButtonVo> getSysUserButtonVoList() {
        return sysUserButtonVoList;
    }

    public void setSysUserButtonVoList(List<SysUserButtonVo> sysUserButtonVoList) {
        this.sysUserButtonVoList = sysUserButtonVoList;
    }
}
