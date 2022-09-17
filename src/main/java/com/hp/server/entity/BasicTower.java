package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BasicTower  {

    private Long id;
    private Long regionId;
    private String tower;
    private Date createTime;

}
