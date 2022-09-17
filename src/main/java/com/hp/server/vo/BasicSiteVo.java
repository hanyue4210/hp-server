package com.hp.server.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class BasicSiteVo {

    private Long id;
    @NotNull(message = "分组id不能为空")
    private Long groupId;
    private Long companyId;
    private String key;
    private String title;
    private String site;
    private Date createTime;
    private List<BasicUnitVo> children;

}
