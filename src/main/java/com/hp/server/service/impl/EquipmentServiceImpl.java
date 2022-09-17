package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.EquipmentMapper;
import com.hp.server.dto.BasicEquipmentDTO;
import com.hp.server.service.EquipmentService;
import com.hp.server.vo.BasicEquipmentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 上午 10:17
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);

    @Autowired
    EquipmentMapper mapper;

    /**
     * 保存设备分类
     *
     * @param vo
     * @return
     */
    @Override
    public Integer save(BasicEquipmentVo vo) {
        if (vo.getIsDeleted() != null) {
            logger.info("删除设备分类");
            return mapper.update(vo);
        }
        BasicEquipmentDTO equipmentDTO = new BasicEquipmentDTO();
        equipmentDTO.setCompanyId(vo.getCompanyId());
        equipmentDTO.setEquipmentType(vo.getEquipmentType());
        List<BasicEquipmentDTO> lists = mapper.getLists(equipmentDTO);
        if (vo.getId() != null) {
            logger.info("更新设备分类");
            if (lists != null && lists.size() > 0) {
                for (BasicEquipmentDTO list : lists) {
                    if (list.getId() != vo.getId()) {
                        return -1;
                    }
                }
            }
            return mapper.update(vo);
        } else {
            logger.info("保存设备分类");
            if (lists != null && lists.size() > 0) {
                return -1;
            }
            return mapper.save(vo);
        }
    }

    /**
     * 分页查询设备分类
     *
     * @param dto
     * @return
     */
    @Override
    public List<BasicEquipmentDTO> getLists(BasicEquipmentDTO dto) {
        if (dto.getBeginRow() != null && dto.getLimitRow() != null) {
            PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        }
        return mapper.getLists(dto);
    }
}
