package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.*;
import com.hp.server.entity.SysUser;
import com.hp.server.result.ResultBody;
import com.hp.server.service.SysUserService;
import com.hp.server.vo.SysUserVo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:mengchen
 * @date:2020/5/19
 * @description:系统用户
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    /**
     * 获取当前用户菜单树
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/getMenuTree")
    public ResultBody getMenuTree(Long userId) {
        return new ResultBody(sysUserService.getMenuTree(userId));
    }

    /**
     * 根据条件查询用户列表
     * @param dto  查询条件
     * @return
     */
    @RequiresPermissions("perm:system:user")
    @GetMapping(value="/listSysUser")
    public ResultBody listSysUser(SysUserQueryDTO dto){
        PageInfo pageInfo = new PageInfo<>(sysUserService.listSysUser(dto));
        return new ResultBody(pageInfo);
    }

    /**
     * 新增用户
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:user:add")
    @PostMapping(value="/saveSysUser")
    public ResultBody saveSysUser(@RequestBody @Valid SysUserDTO dto) {
        ResultBody result = new ResultBody();
        Integer flag = sysUserService.saveSysUser(dto);
        if (flag != null && flag == 1) {
            result.setCode(400);
            result.setMessage("用户名已存在");
            result.setMessageToUser("用户名已存在");
        }
        return result;
    }

    /**
     * 修改用户
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:user:update")
    @PostMapping(value="/updateSysUser")
    public ResultBody updateSysUser(@RequestBody @Valid SysUserDTO dto) {
        ResultBody result = new ResultBody();
        Integer flag = sysUserService.updateSysUser(dto);
        if (flag != null && flag == 1) {
            result.setCode(400);
            result.setMessage("用户名已存在");
            result.setMessageToUser("用户名已存在");
        }
        if (flag != null && flag == 2) {
            result.setCode(400);
            result.setMessage("用户信息不存在，请确认用户ID是否存在");
            result.setMessageToUser("用户信息不存在");
        }
        return result;
    }

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return
     */
    @RequiresPermissions("perm:system:user")
    @GetMapping(value="/getSysUser")
    public ResultBody getSysUser(Long userId) {
        ResultBody result = new ResultBody();
        SysUserVo sysUserVo = sysUserService.getSysUser(userId);
        if (sysUserVo == null) {
            result.setCode(400);
            result.setMessage("用户信息不存在，请确认用户ID是否存在");
            result.setMessageToUser("用户信息不存在");
        } else {
            result.setData(sysUserVo);
        }
        return result;
    }

    /**
     * 删除用户
     * @param userId 用户ID
     * @return
     */
    @RequiresPermissions("perm:system:user:delete")
    @GetMapping(value="/deleteSysUser")
    public ResultBody deleteSysUser(Long userId) {
        ResultBody result = new ResultBody();
        sysUserService.deleteSysUser(userId);
        return result;
    }

    /**
     * 查询用户菜单权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @return
     */
    @RequiresPermissions("perm:system:user:management")
    @GetMapping(value="/listSysUserMenu")
    public ResultBody listSysUserMenu(Long userId) {
        return new ResultBody(sysUserService.listSysUserMenu(userId));
    }

    /**
     * 设置用户菜单权限
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:user:management")
    @PostMapping(value="/setSysUserMenu")
    public ResultBody setSysUserMenu(@RequestBody @Valid SysUserMenuDTO dto) {
        ResultBody result = new ResultBody();
        sysUserService.setSysUserMenu(dto);
        return result;
    }

    /**
     * 查询用户按钮权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @param menuKey 菜单Key
     * @return
     */
    @RequiresPermissions("perm:system:user:management")
    @GetMapping(value="/listSysUserButton")
    public ResultBody listSysUserButton(Long userId, String menuKey) {
        return new ResultBody(sysUserService.listSysUserButton(userId, menuKey));
    }

    /**
     * 设置用户按钮权限
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:user:management")
    @PostMapping(value="/setSysUserButton")
    public ResultBody setSysUserButton(@RequestBody @Valid SysUserButtonDTO dto) {
        ResultBody result = new ResultBody();
        sysUserService.setSysUserButton(dto);
        return result;
    }

    /**
     * 修改密码
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:passord:save")
    @PostMapping(value = "/updatePassword")
    public ResultBody updatePassword(@RequestBody PasswordDTO dto) {
        ResultBody result = new ResultBody();
        String oldPassword = dto.getOldPassword();
        String newPassword = dto.getNewPassword();
        Integer flag = sysUserService.updatePassword(oldPassword, newPassword);
        if (flag != null && flag == 0) {
            result.setCode(400);
            result.setMessage("旧密码错误");
            result.setMessageToUser("旧密码错误");
        }
        return result;
    }

    /**
     * 设置用户权限
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:user:management")
    @PostMapping(value="/setSysAuth")
    public ResultBody setSysAuth(@RequestBody @Valid SysAuthDTO dto) {
        ResultBody result = new ResultBody();
        sysUserService.setSysAuth(dto);
        return result;
    }

}
