package com.hp.server.service;

import com.hp.server.dto.*;
import com.hp.server.entity.SysUser;
import com.hp.server.vo.*;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/19
 * @description:系统用户相关接口
 */
public interface SysUserService {
    /**
     * 根据登录名查询用户信息
     * @param loginName 登录名
     * @return
     */
    SysUser findByLoginName(String loginName);

    /**
     * 获取当前用户菜单树
     * @return
     * @param userId
     */
    List<SysAuthVo> getMenuTree(Long userId);

    /**
     * 获取当前用户权限
     * @return
     */
    List<String> listAuth();

    /**
     * 根据条件查询用户列表
     * @param dto  查询条件
     * @return
     */
    List<SysUserVo> listSysUser(SysUserQueryDTO dto);

    /**
     * 新增用户
     * @param dto 请求参数
     * @return
     */
    Integer saveSysUser(SysUserDTO dto);

    /**
     * 修改用户
     * @param dto 请求参数
     * @return
     */
    Integer updateSysUser(SysUserDTO dto);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return
     */
    SysUserVo getSysUser(Long userId);

    /**
     * 删除用户
     * @param userId 用户ID
     */
    void deleteSysUser(Long userId);

    /**
     * 查询用户菜单权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @return
     */
    List<SysUserMenuVo> listSysUserMenu(Long userId);

    /**
     * 设置用户菜单权限
     * @param dto 请求参数
     */
    void setSysUserMenu(SysUserMenuDTO dto);

    /**
     * 查询用户按钮权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @param menuKey 菜单Key
     * @return
     */
    List<SysUserButtonVo> listSysUserButton(Long userId, String menuKey);

    /**
     * 设置用户按钮权限
     * @param dto 请求参数
     * @return
     */
    void setSysUserButton(SysUserButtonDTO dto);

    /**
     * 修改密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    Integer updatePassword(String oldPassword, String newPassword);

    /**
     * 设置用户权限
     * @param dto 请求参数
     * @return
     */
    void setSysAuth(SysAuthDTO dto);
}
