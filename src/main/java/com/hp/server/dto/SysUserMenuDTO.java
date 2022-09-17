package com.hp.server.dto;

import com.hp.server.vo.SysUserMenuVo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:设置用户菜单权限
 */
public class SysUserMenuDTO {
    @NotNull(message = "用户ID不能为空！")
    private Long userId;
    private List<SysUserMenuVo> sysUserMenuVoList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<SysUserMenuVo> getSysUserMenuVoList() {
        return sysUserMenuVoList;
    }

    public void setSysUserMenuVoList(List<SysUserMenuVo> sysUserMenuVoList) {
        this.sysUserMenuVoList = sysUserMenuVoList;
    }
}
