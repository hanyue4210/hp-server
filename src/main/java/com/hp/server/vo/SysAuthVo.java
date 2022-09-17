package com.hp.server.vo;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/25
 * @description:权限设置
 */
public class SysAuthVo {
    private Long id;
    private String name;
    private String key;
    private Integer isOpen;
    private List<SysAuthVo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public List<SysAuthVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysAuthVo> children) {
        this.children = children;
    }
}
