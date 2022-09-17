package com.hp.server.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class BasicTowerVo {

    private Long id;
    @NotNull(message = "小区id不能为空")
    private Long regionId;
    private String tower;
    private Long companyId;
    private Date createTime;
    private String key;
    private String title;
    private List<BasicCellVo> children;
}
