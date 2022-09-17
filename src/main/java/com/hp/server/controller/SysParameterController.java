package com.hp.server.controller;

import com.hp.server.dto.SysParameterDTO;
import com.hp.server.result.ResultBody;
import com.hp.server.service.SysParameterService;
import com.hp.server.vo.SysParameterVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author:mengchen
 * @date:2020/5/21
 * @description:参数设置
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/sysParameter")
public class SysParameterController {
    @Resource
    private SysParameterService sysParameterService;

    /**
     * 查询参数设置
     * @return
     */
    @RequiresPermissions("perm:system:parameter")
    @GetMapping("/getSysParameter")
    public ResultBody getSysParameter() {
        return new ResultBody(sysParameterService.getSysParameter());
    }

    /**
     * 参数设置
     * @param dto 请求参数
     * @return
     */
    @RequiresPermissions("perm:system:parameter:update")
    @PostMapping(value="/saveSysParamter")
    public ResultBody saveSysParamter(@RequestBody @Valid SysParameterDTO dto) {
        ResultBody result = new ResultBody();
        sysParameterService.saveSysParamter(dto);
        return result;
    }
}
