package com.hp.server.dao;

import com.hp.server.dto.ProductRegistDTO;
import com.hp.server.vo.ProductRegistVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:40
 */
@Mapper
public interface ProductRegistMapper {
    /**
     * 保存产品登记
     *
     * @param vo
     * @return
     */
    Integer save(ProductRegistVo vo);

    /**
     * 更新产品登记
     *
     * @param vo
     * @return
     */
    Integer update(ProductRegistVo vo);

    /**
     * 分页查询产品登记
     *
     * @param dto
     * @return
     */
    List<ProductRegistDTO> getLists(ProductRegistDTO dto);
}
