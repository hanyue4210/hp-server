package com.hp.server.service;

import com.hp.server.dto.SysParameterDTO;
import com.hp.server.vo.SysParameterVo;

import java.util.List;

public interface SysParameterService {
    /**
     * 查询参数设置
     * @return
     */
    SysParameterVo getSysParameter();

    /**
     * 参数设置
     * @param dto 请求参数
     * @return
     */
    void saveSysParamter(SysParameterDTO dto);
}
