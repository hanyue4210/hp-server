package com.hp.server.dao;

import com.hp.server.dto.ApManagerDTO;
import com.hp.server.vo.ApManagerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 03:27
 */
@Mapper
public interface ApManagerMapper {
    /**
     * 保存接入点管理
     *
     * @param vo
     * @return
     */
    Integer save(ApManagerVo vo);

    /**
     * 更新接入点管理
     *
     * @param vo
     * @return
     */
    Integer update(ApManagerVo vo);

    /**
     * 分页查询接入点管理
     *
     * @param dto
     * @return
     */
    List<ApManagerDTO> getLists(ApManagerDTO dto);
}
