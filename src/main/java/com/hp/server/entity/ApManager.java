package com.hp.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author hanyue
 * @create 2020-06-29 下午 03:23
 */
@Data
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ApManager {
    private Integer id;
    private Integer companyId;
    private String apCode;
    private String apName;
    private String imei;
    private String imeiCode;
    private String status;
    private String takeStatus;
    private Integer isDeleted;
    private String remarks;

}
