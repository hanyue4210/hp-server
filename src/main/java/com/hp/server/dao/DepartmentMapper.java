package com.hp.server.dao;

import com.hp.server.dto.basicDepartmentDTO;
import com.hp.server.vo.basicDepartmentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-28 下午 03:03
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 保存部门
     * @param vo
     * @return
     */
    Integer save(basicDepartmentVo vo);
    /**
     * ge部门
     * @param vo
     * @return
     */
    Integer update(basicDepartmentVo vo);

    /**
     * 获取分页列表
     * @param dto
     * @return
     */
    List<basicDepartmentDTO> getLists(basicDepartmentDTO dto);

}
