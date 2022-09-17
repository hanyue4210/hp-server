package com.hp.server.dao;

import com.hp.server.dto.BasicEquipmentDTO;
import com.hp.server.vo.BasicEquipmentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 上午 10:03
 */
@Mapper
public interface EquipmentMapper {

    /**
     * 保存设备分类
     *
     * @param vo
     * @return
     */
    Integer save(BasicEquipmentVo vo);

    /**
     * 更新设备分类
     *
     * @param vo
     * @return
     */
    Integer update(BasicEquipmentVo vo);

    /**
     * 分页查询设备分类
     *
     * @param dto
     * @return
     */
    List<BasicEquipmentDTO> getLists(BasicEquipmentDTO dto);
}
