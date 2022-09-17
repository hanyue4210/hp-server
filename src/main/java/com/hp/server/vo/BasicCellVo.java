package com.hp.server.vo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BasicCellVo {

    private Long id;
    @NotNull(message = "楼宇id不能为空")
    private Long towerId;
    @NotNull(message = "小区id不能为空")
    private Long regionId;
    private String cell;
    private String key;
    private String title;
    private Date createTime;
    private Long companyId;

}
