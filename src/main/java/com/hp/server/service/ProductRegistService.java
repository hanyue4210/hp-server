package com.hp.server.service;

import com.hp.server.dto.ProductRegistDTO;
import com.hp.server.vo.ProductRegistVo;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 03:08
 */
public interface ProductRegistService {
    /**
     * 保存产品登记
     *
     * @param vo
     * @return
     */
    Integer save(ProductRegistVo vo);

    /**
     * 分页查询产品登记
     *
     * @param dto
     * @return
     */
    List<ProductRegistDTO> getLists(ProductRegistDTO dto);
}
