package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BasicSite  {

    private Long id;
    private Long groupId;
    private String site;
    private Date createTime;
}
