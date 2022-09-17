package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.SysUserMapper;
import com.hp.server.dto.*;
import com.hp.server.entity.*;
import com.hp.server.service.SysUserService;
import com.hp.server.vo.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/19
 * @description:系统用户相关业务实现
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Value("${default.password}")
    private String defaultPassword;
    @Resource
    private SysUserMapper sysUserMapper;
    /**
     * 根据登录名查询用户信息
     * @param loginName 登录名
     * @return
     */
    @Override
    public SysUser findByLoginName(String loginName) {
        return sysUserMapper.findByLoginName(loginName);
    }

    /**
     * 获取当前用户菜单树
     * @return
     * @param userId
     */
    @Override
    public List<SysAuthVo> getMenuTree(Long userId) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        Integer isVisible = 1;
        if (sysUser.getUserOrigin() == 1) {
            isVisible = null;
        }

        // 根据用户ID查询用户拥有菜单
        List<SysMenu> listSysMenu = sysUserMapper.listAllSysMenuByLevelAndVisible(1, isVisible);

        ArrayList<SysAuthVo> authList = new ArrayList<SysAuthVo>();

        for (SysMenu item : listSysMenu) {
            // 一级菜单
            SysAuthVo sysAuthVo = new SysAuthVo();
            sysAuthVo.setId(item.getId());
            sysAuthVo.setName(item.getMenuName());
            sysAuthVo.setKey(item.getMenuKey());
            sysAuthVo.setIsOpen(0);
            // 二级菜单
            List<SysAuthVo> childrenAuthList = sysUserMapper.listSysMenuIsOpenByParentId(userId, item.getId());
            sysAuthVo.setChildren(childrenAuthList);

            // 按钮
            for (SysAuthVo item1 : childrenAuthList) {
                // 通过二级菜单判断一级是否选中
                if (item1.getIsOpen() == 1) {
                    sysAuthVo.setIsOpen(1);
                }
                ArrayList<SysAuthVo> childrenAuthButtonList = sysUserMapper.listSysUserButtonIsOpenOpt(userId, item1.getKey());
                item1.setChildren(childrenAuthButtonList);
            }
            authList.add(sysAuthVo);
        }

        return authList;
    }

    /**
     * 获取当前用户权限
     * @return
     */
    @Override
    public List<String> listAuth() {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        ArrayList<String> listAuth = new ArrayList<String>();

        // 根据用户ID查询用户拥有菜单
        List<SysMenu> listSysMenu = sysUserMapper.listSysUserMenu(sysUser.getId());
        for (SysMenu item : listSysMenu) {
            listAuth.add(item.getMenuKey());
        }

        // 根据用户ID查询用户拥有按钮
        List<SysButton> listSysButton = sysUserMapper.listSysButton(sysUser.getId());
        for (SysButton item : listSysButton) {
            if (item != null) {
                listAuth.add(item.getMenuKey() + ":" + item.getButtonKey());
            }

        }
        return listAuth;
    }

    /**
     * 根据条件查询用户列表
     * @param dto  查询条件
     * @return
     */
    @Override
    public List<SysUserVo> listSysUser(SysUserQueryDTO dto) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        if (sysUser.getUserOrigin() == 2) {
            dto.setCompanyId(sysUser.getCompanyId());
        }
        return sysUserMapper.listSysUser(dto);
    }

    /**
     * 新增用户
     * @param dto 请求参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveSysUser(SysUserDTO dto) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        SysUser sysUser1 = sysUserMapper.findByLoginName(dto.getLoginName());
        // 用户名已存在
        if (sysUser1 != null) {
            return 1;
        }
        String pwdMd5 = new SimpleHash("md5", dto.getPassword(), defaultPassword, 2).toHex();
        if (!StringUtils.isEmpty(dto.getPassword())) {
            pwdMd5 = new SimpleHash("md5", dto.getPassword(), null, 2).toHex();
        }
        dto.setPassword(pwdMd5);

        dto.setCompanyId(sysUser.getCompanyId());

        // 如果参数传入了用户来源，则按传入参数插入，用于凡尔创建热力公司管理员账户
        // 如果没传用户来源，则按当前操作账户的来源，即凡尔创建凡尔用户，热力创建热力用户
        if (dto.getUserOrigin() != null) {
            dto.setUserOrigin(dto.getUserOrigin());
        } else {
            dto.setUserOrigin(sysUser.getUserOrigin());
        }

        // 创建用户
        sysUserMapper.saveSysUser(dto);

        Long userId = dto.getId();

        // 默认拥有菜单权限 二级菜单 热力可见
        List<SysMenu> listAllMenu = sysUserMapper.listAllSysMenuByLevelAndVisible(2, 1);

        List<SysUserMenu> listUserMenu = new ArrayList<SysUserMenu>();

        for (SysMenu item : listAllMenu) {
            SysUserMenu sysUserMenu = new SysUserMenu();
            sysUserMenu.setMenuId(item.getId());
            sysUserMenu.setUserId(userId);
            listUserMenu.add(sysUserMenu);
        }
        // 批量插入用户菜单权限
        sysUserMapper.saveSysUserMenuBatch(listUserMenu);

        // 默认拥有菜单下的全部按钮权限
        List<SysButton> listAllButton = new ArrayList<SysButton>();
        for (SysMenu item : listAllMenu) {
            // 查询菜单下的按钮
            List<SysButton> listButton = sysUserMapper.listSysButtonByMenu(item.getMenuKey());
            listAllButton.addAll(listButton);
        }

        List<SysUserButton> listUserButton = new ArrayList<SysUserButton>();
        for (SysButton item : listAllButton) {
            SysUserButton sysUserButton = new SysUserButton();
            sysUserButton.setButtonId(item.getId());
            sysUserButton.setUserId(userId);;
            listUserButton.add(sysUserButton);
        }

        // 批量插入用户按钮权限
        sysUserMapper.saveSysUserButtonBatch(listUserButton);


        return 0;
    }

    /**
     * 修改用户
     * @param dto 请求参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateSysUser(SysUserDTO dto) {
        // 根据用户ID查询用户
        SysUserVo sysUserVo = sysUserMapper.getSysUserById(dto.getId());
        // 用户信息不存在，请确认用户ID是否存在
        if (sysUserVo == null) {
            return 2;
        }

        String oldLoginName = sysUserVo.getLoginName();
        String newLoginName = dto.getLoginName();

        // 如果修改用户名，判断用户名是否已存在
        if (!oldLoginName.equals(newLoginName)) {
            SysUser sysUser1 = sysUserMapper.findByLoginName(newLoginName);
            if (sysUser1 != null) {
                return 1;
            }
        }

        if (!StringUtils.isEmpty(dto.getPassword())) {
            String pwdMd5 = new SimpleHash("md5", dto.getPassword(), null, 2).toHex();
            dto.setPassword(pwdMd5);
        }

        // 修改用户
        sysUserMapper.updateSysUser(dto);
        return 0;
    }

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return
     */
    @Override
    public SysUserVo getSysUser(Long userId) {
        return sysUserMapper.getSysUserById(userId);
    }

    /**
     * 删除用户
     * @param userId 用户ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(Long userId) {
        // 删除用户 逻辑删除
        sysUserMapper.deleteSysUser(userId);

        // 删除用户关联菜单权限 物理删除
        sysUserMapper.deleteSysUserMenu(userId);

        // 删除用户关联按钮权限 物理删除
        sysUserMapper.deleteSysUserButton(userId);
    }

    /**
     * 查询用户菜单权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<SysUserMenuVo> listSysUserMenu(Long userId) {
        return sysUserMapper.listSysMenuIsOpen(userId, 2, 1);
    }

    /**
     * 设置用户菜单权限
     * @param dto 请求参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setSysUserMenu(SysUserMenuDTO dto) {
        Long userId = dto.getUserId();

        // 选中的菜单ID
        ArrayList<Long> checkedMenuList = new ArrayList<Long>();
        // 未选中的菜单Key
        ArrayList<String> unCheckedMenuList = new ArrayList<String>();

        for (SysUserMenuVo item : dto.getSysUserMenuVoList()) {
            if (item.getIsOpen() == 1) {
                checkedMenuList.add(item.getMenuId());
            } else {
                unCheckedMenuList.add(item.getMenuKey());
            }

        }

        // 删除原有菜单权限
        sysUserMapper.deleteSysUserMenu(userId);

        // 删除未选中的菜单下的用户按钮权限
        sysUserMapper.deleteSysUserButtonByUserIdAndMenuId(userId,unCheckedMenuList);


        // 添加新菜单权限
        ArrayList<SysUserMenu> listSysUserMenu = new ArrayList<SysUserMenu>();
        for (Long item : checkedMenuList) {
            SysUserMenu sysUserMenu = new SysUserMenu();
            sysUserMenu.setUserId(userId);
            sysUserMenu.setMenuId(item);
            listSysUserMenu.add(sysUserMenu);
        }
        sysUserMapper.saveSysUserMenuBatch(listSysUserMenu);

    }

    /**
     * 查询用户按钮权限列表（功能权限设置列表）
     * @param userId 用户ID
     * @param menuKey 菜单Key
     * @return
     */
    @Override
    public List<SysUserButtonVo> listSysUserButton(Long userId, String menuKey) {
        return sysUserMapper.listSysUserButtonIsOpen(userId, menuKey);
    }

    /**
     * 设置用户按钮权限
     * @param dto 请求参数
     * @return
     */
    @Override
    public void setSysUserButton(SysUserButtonDTO dto) {
        Long userId = dto.getUserId();
        String menuKey = dto.getMenuKey();

        // 选中的按钮ID
        ArrayList<Long> checkedButtonList = new ArrayList<Long>();
        for (SysUserButtonVo item : dto.getSysUserButtonVoList()) {
            if (item.getIsOpen() == 1) {
                checkedButtonList.add(item.getButtonId());
            }

        }

        // 封装需要删除的菜单按钮
        ArrayList<String> unCheckedMenuList = new ArrayList<String>();
        unCheckedMenuList.add(menuKey);

        // 删除原有按钮权限
        sysUserMapper.deleteSysUserButtonByUserIdAndMenuId(userId,unCheckedMenuList);

        // 添加新按钮权限
        ArrayList<SysUserButton> listSysUseButton = new ArrayList<SysUserButton>();
        for (Long item : checkedButtonList) {
            SysUserButton sysUserButton = new SysUserButton();
            sysUserButton.setUserId(userId);
            sysUserButton.setButtonId(item);
            listSysUseButton.add(sysUserButton);
        }
        sysUserMapper.saveSysUserButtonBatch(listSysUseButton);
    }

    /**
     * 修改密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    @Override
    public Integer updatePassword(String oldPassword, String newPassword) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        String oldPwdMd5 = new SimpleHash("md5", oldPassword, null, 2).toHex();
        String newPwdMd5 = new SimpleHash("md5", newPassword, null, 2).toHex();

        if(!sysUser.getPassword().equals(oldPwdMd5)){
            return 0;
        }

        sysUser.setPassword(newPwdMd5);
        sysUserMapper.updatePassword(sysUser.getId(), newPwdMd5);
        return 1;
    }

    /**
     * 设置用户权限
     * @param dto 请求参数
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setSysAuth(SysAuthDTO dto) {
        Long userId = dto.getUserId();
        // 删除原有菜单权限
        sysUserMapper.deleteSysUserMenu(userId);
        // 删除原有按钮权限
        sysUserMapper.deleteSysUserButton(userId);

        // 添加新菜单权限
        ArrayList<SysUserMenu> listSysUserMenu = new ArrayList<SysUserMenu>();
        for (Long item : dto.getMenuList()) {
            SysUserMenu sysUserMenu = new SysUserMenu();
            sysUserMenu.setUserId(userId);
            sysUserMenu.setMenuId(item);
            listSysUserMenu.add(sysUserMenu);
        }
        sysUserMapper.saveSysUserMenuBatch(listSysUserMenu);

        // 添加新按钮权限
        ArrayList<SysUserButton> listSysUseButton = new ArrayList<SysUserButton>();
        for (Long item : dto.getButtonList()) {
            SysUserButton sysUserButton = new SysUserButton();
            sysUserButton.setUserId(userId);
            sysUserButton.setButtonId(item);
            listSysUseButton.add(sysUserButton);
        }
        sysUserMapper.saveSysUserButtonBatch(listSysUseButton);

    }
}
