package com.hp.server.dao;

import com.hp.server.dto.SysParameterDTO;
import com.hp.server.vo.SysParameterVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysParameterMapper {
    /**
     * 查询参数设置
     * @return
     * @param companyId 所属公司ID
     */
    SysParameterVo getSysParameter(Long companyId);

    /**
     * 更新参数设置
     * @param dto 请求参数
     */
    void updateSysParamter(SysParameterDTO dto);

    /**
     * 新增参数设置
     * @param dto 请求参数
     */
    void saveSysParamter(SysParameterDTO dto);
}
