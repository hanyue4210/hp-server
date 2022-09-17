package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.DepartmentMapper;
import com.hp.server.dto.basicDepartmentDTO;
import com.hp.server.service.DepartmentService;
import com.hp.server.vo.basicDepartmentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-28 下午 03:41
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);


    @Autowired
    DepartmentMapper mapper;


    /**
     * 保存*更新部门
     *
     * @param vo
     * @return
     */
    @Override
    public Integer save(basicDepartmentVo vo) {
        if (vo.getIsDeleted() != null) {
            logger.info("删除部门");
            return mapper.update(vo);
        }
        basicDepartmentDTO departmentDTO = new basicDepartmentDTO();
        departmentDTO.setCompanyId(vo.getCompanyId());
        departmentDTO.setDepartmentName(vo.getDepartmentName());
        List<basicDepartmentDTO> lists = mapper.getLists(departmentDTO);
        if (vo.getId() != null) {
            logger.info("更新部门");
            if (lists != null && lists.size() > 0) {
                for (basicDepartmentDTO list : lists) {
                    if (list.getId() != vo.getId()) {
                        return -1;
                    }
                }
            }
            return mapper.update(vo);
        } else {
            logger.info("保存部门");
            if (lists != null && lists.size() > 0) {
                return -1;
            }
            return mapper.save(vo);
        }
    }

    /**
     * 获取分页列表
     *
     * @param dto
     * @return
     */
    @Override
    public List<basicDepartmentDTO> getLists(basicDepartmentDTO dto) {
        if (dto.getBeginRow() != null && dto.getLimitRow() != null) {
            PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        }
        return mapper.getLists(dto);
    }

    /**
     * 逻辑删除部门
     *
     * @param vo
     * @return
     */
    @Override
    public Integer del(basicDepartmentVo vo) {
        vo.setIsDeleted(1);
        return mapper.update(vo);
    }

}
