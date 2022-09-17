package com.hp.server.service.impl;

import com.hp.server.dao.SysParameterMapper;
import com.hp.server.dto.SysParameterDTO;
import com.hp.server.entity.SysUser;
import com.hp.server.service.SysParameterService;
import com.hp.server.vo.SysParameterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:参数设置
 */
@Service
public class SysParameterServiceImpl implements SysParameterService {
    @Resource
    private SysParameterMapper sysParameterMapper;

    /**
     * 查询参数设置
     * @return
     */
    @Override
    public SysParameterVo getSysParameter() {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        return sysParameterMapper.getSysParameter(sysUser.getCompanyId());
    }

    /**
     * 参数设置
     * @param dto 请求参数
     * @return
     */
    @Override
    public void saveSysParamter(SysParameterDTO dto) {
        if (dto.getId() != null) {
            sysParameterMapper.updateSysParamter(dto);
        } else {
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            dto.setCompanyId(sysUser.getCompanyId());
            sysParameterMapper.saveSysParamter(dto);
        }

    }
}
