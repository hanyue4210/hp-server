package com.hp.server.service;

import com.hp.server.dto.basicDepartmentDTO;
import com.hp.server.vo.basicDepartmentVo;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-28 下午 03:40
 */
public interface DepartmentService {
    /**
     * 保存*更新部门
     *
     * @param vo
     * @return
     */
    Integer save(basicDepartmentVo vo);

    /**
     * 获取分页列表
     *
     * @param dto
     * @return
     */
    List<basicDepartmentDTO> getLists(basicDepartmentDTO dto);

    /**
     * 逻辑删除部门
     *
     * @param vo
     * @return
     */
    Integer del(basicDepartmentVo vo);
}
