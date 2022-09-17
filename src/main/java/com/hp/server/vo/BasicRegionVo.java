package com.hp.server.vo;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BasicRegionVo {

    private Long id;
    private Long companyId;
    private String region;
    private String key;
    private String title;
    private Date createTime;
    private List<BasicTowerVo> children;

}
