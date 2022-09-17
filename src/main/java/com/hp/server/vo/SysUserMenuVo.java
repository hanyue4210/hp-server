package com.hp.server.vo;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:用户菜单权限
 */
public class SysUserMenuVo {
    private Long menuId;
    private String menuName;
    private String menuKey;
    // 用户是否拥有菜单权限 1是 0否
    private Integer isOpen;
    private Long parentId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
