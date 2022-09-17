package com.hp.server.service;

import com.hp.server.dto.BasicEquipmentDTO;
import com.hp.server.vo.BasicEquipmentVo;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 上午 10:16
 */
public interface EquipmentService {
    /**
     * 保存设备分类
     *
     * @param vo
     * @return
     */
    Integer save(BasicEquipmentVo vo);

    /**
     * 分页查询设备分类
     *
     * @param dto
     * @return
     */
    List<BasicEquipmentDTO> getLists(BasicEquipmentDTO dto);
}
