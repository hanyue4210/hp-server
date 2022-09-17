package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.ApManagerMapper;
import com.hp.server.dto.ApManagerDTO;
import com.hp.server.service.ApManagerService;
import com.hp.server.vo.ApManagerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-30 下午 01:58
 */
@Service
public class ApManagerServiceImpl implements ApManagerService {

    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);


    @Autowired
    ApManagerMapper mapper;

    /**
     * 保存接入点管理
     *
     * @param vo
     * @return
     */
    @Override
    public Integer save(ApManagerVo vo) {
        if (vo.getIsDeleted() != null) {
            logger.info("删除接入点");
            return mapper.update(vo);
        }
        ApManagerDTO apManagerDTO = new ApManagerDTO();
        apManagerDTO.setCompanyId(vo.getCompanyId());
        apManagerDTO.setApCode(vo.getApCode());
        List<ApManagerDTO> lists = mapper.getLists(apManagerDTO);
        if (vo.getId() != null) {
            logger.info("更新接入点");
            if (lists != null && lists.size() > 0) {
                for (ApManagerDTO list : lists) {
                    if (list.getId() != vo.getId()) {
                        return -1;
                    }
                }
            }
            return mapper.update(vo);
        } else {
            logger.info("保存接入点");
            if (lists != null && lists.size() > 0) {
                return -1;
            }
            return mapper.save(vo);
        }
    }

    /**
     * 分页查询接入点管理
     *
     * @param dto
     * @return
     */
    @Override
    public List<ApManagerDTO> getLists(ApManagerDTO dto) {
        if (dto.getBeginRow() != null && dto.getLimitRow() != null) {
            PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        }
        return mapper.getLists(dto);
    }
}
