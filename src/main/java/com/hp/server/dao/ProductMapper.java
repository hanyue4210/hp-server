package com.hp.server.dao;

import com.hp.server.dto.BasicProductDTO;
import com.hp.server.vo.BasicProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:11
 */
@Mapper
public interface ProductMapper {

    /**
     * 保存设备分类
     *
     * @param vo
     * @return
     */
    Integer save(BasicProductVo vo);

    /**
     * 更新设备分类
     *
     * @param vo
     * @return
     */
    Integer update(BasicProductVo vo);

    /**
     * 分页查询设备分类
     *
     * @param dto
     * @return
     */
    List<BasicProductDTO> getLists(BasicProductDTO dto);
}
