package com.hp.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:06
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BasicProduct {
    private Integer id;
    private Integer companyId;
    private String productType;
    private String remarks;
    private Integer isDeleted;

}
