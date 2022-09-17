package com.hp.server.service;

import com.hp.server.dto.BasicProductDTO;
import com.hp.server.vo.BasicProductVo;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:18
 */
public interface ProductService {
    /**
     * 保存设备分类
     *
     * @param vo
     * @return
     */
    Integer save(BasicProductVo vo);

    /**
     * 分页查询设备分类
     *
     * @param dto
     * @return
     */
    List<BasicProductDTO> getLists(BasicProductDTO dto);
}
