package com.hp.server.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BasicGroupVo {

    private Long id;
    private String groups;
    private Long companyId;
    private String key;
    private String title;
    private Date createTime;
    private List<BasicSiteVo> children;
}
