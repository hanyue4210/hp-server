package com.hp.server.dao;

import com.hp.server.dto.SysUserDTO;
import com.hp.server.dto.SysUserQueryDTO;
import com.hp.server.entity.*;
import com.hp.server.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SysUserMapper {
    /**
     * 根据登录名查询用户信息
     * @param loginName 登录名
     * @return
     */
    SysUser findByLoginName(String loginName);

    /**
     * 根据用户ID查询用户拥有菜单
     * @param userId 用户ID
     * @return
     */
    List<SysMenu> listSysUserMenu(Long userId);

    /**
     * 根据菜单ID查询菜单
     * @param id 菜单ID
     * @return
     */
    SysMenu getSysMenuById(Long id);

    /**
     * 根据用户ID查询用户拥有按钮
     * @param id 按钮ID
     * @return
     */
    List<SysButton> listSysButton(Long id);

    /**
     * 根据条件查询用户列表
     * @param dto  查询条件
     * @return
     */
    List<SysUserVo> listSysUser(SysUserQueryDTO dto);

    /**
     * 创建用户
     * @param dto 请求参数
     */
    void saveSysUser(SysUserDTO dto);

    /**
     * 根据菜单等级查询菜单
     * @param menuLevel 菜单等级
     * @param isVisible 热力公司是否可见
     * @return
     */
    List<SysMenu> listAllSysMenuByLevelAndVisible(@Param("menuLevel") Integer menuLevel, @Param("isVisible") Integer isVisible);

    /**
     * 批量插入用户菜单权限
     * @param listUserMenu 菜单列表
     */
    void saveSysUserMenuBatch(List<SysUserMenu> listUserMenu);

    /**
     * 查询菜单下的按钮
     * @param menuKey 菜单Key
     * @return
     */
    List<SysButton> listSysButtonByMenu(String menuKey);

    /**
     * 批量插入用户按钮权限
     * @param listUserButton 按钮列表
     */
    void saveSysUserButtonBatch(List<SysUserButton> listUserButton);

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     * @return
     */
    SysUserVo getSysUserById(Long id);

    /**
     * 修改用户
     * @param dto 请求参数
     */
    void updateSysUser(SysUserDTO dto);

    /**
     * 删除用户
     * @param userId 用户ID
     */
    void deleteSysUser(Long userId);

    /**
     * 删除用户关联菜单权限
     * @param userId 用户ID
     */
    void deleteSysUserMenu(Long userId);

    /**
     * 删除用户关联按钮权限
     * @param userId 用户ID
     */
    void deleteSysUserButton(Long userId);

    /**
     * 查询用户菜单权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @param menuLevel 菜单等级
     * @param isVisible 热力公司是否可见
     * @return
     */
    List<SysUserMenuVo> listSysMenuIsOpen(@Param("userId") Long userId, @Param("menuLevel") Integer menuLevel, @Param("isVisible") Integer isVisible);

    /**
     * 删除未选中的菜单下的用户按钮权限
     * @param userId 用户ID
     * @param unCheckedMenuList 未选中菜单ID列表
     */
    void deleteSysUserButtonByUserIdAndMenuId(@Param("userId") Long userId, @Param("unCheckedMenuList") ArrayList<String> unCheckedMenuList);

    /**
     * 查询用户按钮权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @param menuKey 菜单Key
     * @return
     */
    List<SysUserButtonVo> listSysUserButtonIsOpen(@Param("userId") Long userId, @Param("menuKey") String menuKey);

    /**
     * 修改密码
     * @param userId 用户密码
     * @param password 用户新密码
     */
    void updatePassword(@Param("userId") Long userId, @Param("password") String password);

    /**
     * 查询用户按钮权限列表
     * @param userId 用户ID
     * @param menuKey 菜单Key
     * @return
     */
    ArrayList<SysAuthVo> listSysUserButtonIsOpenOpt(@Param("userId") Long userId, @Param("menuKey") String menuKey);

    /**
     * 根据父菜单ID查询子菜单
     *
     * @param userId 用户ID
     * @param parentId 父级菜单ID
     * @return
     */
    List<SysAuthVo> listSysMenuIsOpenByParentId(@Param("userId") Long userId, @Param("parentId") Long parentId);
}
