package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BasicCell {

    private Long id;
    private Long towerId;
    private String cell;
    private Date createTime;


}
