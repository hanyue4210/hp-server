package com.hp.server.vo;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/20
 * @description:左侧菜单树
 */
public class SysMenuVo {
    private String menuName;
    private String menuKey;
    private List<SysMenuVo> childrenMenu;

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

    public List<SysMenuVo> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(List<SysMenuVo> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }
}
