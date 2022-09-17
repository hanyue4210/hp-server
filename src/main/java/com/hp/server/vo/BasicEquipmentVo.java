package com.hp.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hanyue
 * @create 2020-06-29 上午 09:57
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BasicEquipmentVo {
    private Integer id;
    @NotNull(message = "companyId is null")
    private Integer companyId;
    private String equipmentType;
    private String equipmentClass;
    private String remarks;
    private Integer isDeleted;
}
