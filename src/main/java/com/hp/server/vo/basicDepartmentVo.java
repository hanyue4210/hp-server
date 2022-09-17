package com.hp.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hanyue
 * @create 2020-06-28 下午 02:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class basicDepartmentVo {
    private Integer id;
    private Date createTime;
    @NotNull(message = "companyId is null")
    private Integer companyId;
    private String departmentName;
    private String managerPeo;
    private String remarks;
    private Integer isDeleted;
}
