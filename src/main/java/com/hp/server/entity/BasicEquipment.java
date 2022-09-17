package com.hp.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author hanyue
 * @create 2020-06-29 上午 09:57
 */
@Data
@ToString
@AllArgsConstructor
@NotBlank
@Accessors(chain = true)
public class BasicEquipment {
    private Integer id;
    private Integer companyId;
    private String equipmentType;
    private String equipmentClass;
    private String remarks;
    private Integer isDeleted;
}
