package com.hp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BasicRegion {

    private Long id;
    private String region;
    private Long companyId;
    private Date createTime;
}
