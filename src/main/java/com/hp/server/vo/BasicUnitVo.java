package com.hp.server.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BasicUnitVo {
    private Long id;
    @NotNull(message = "热换站id不能为空")
    private Long siteId;
    @NotNull(message = "分组id不能为空")
    private Long groupId;
    private String unit;
    private Date createTime;
    private Long companyId;
    private String factory;
    private String key;
    private String title;
    private String type;
    private String power;
    private String diameter1;
    private String diameter2;
    private String plateArea;
    private String exchangeRate;
    private String regionDescribe;

}
