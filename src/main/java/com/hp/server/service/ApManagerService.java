package com.hp.server.service;

import com.hp.server.dto.ApManagerDTO;
import com.hp.server.vo.ApManagerVo;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-30 下午 01:58
 */
public interface ApManagerService {
    /**
     * 保存接入点管理
     *
     * @param vo
     * @return
     */
    Integer save(ApManagerVo vo);

    /**
     * 分页查询接入点管理
     *
     * @param dto
     * @return
     */
    List<ApManagerDTO> getLists(ApManagerDTO dto);
}
