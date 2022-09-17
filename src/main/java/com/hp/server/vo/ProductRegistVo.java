package com.hp.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:35
 */
@Data
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegistVo {
    private Integer id;
    private Date createTime;
    private Integer companyId;
    private String productNum;
    private String deviceCode;
    private String imei;
    private String imsi;
    private String equipmentName;
    private String equipmentType;
    private String productType;
    private String equipmentCode;
    private String productDate;
    private String chenkPeo;
    private String inputDate;
    private String inputPeo;
    private String leaveDate;
    private String remarks;
    private Integer isDeleted;

}
