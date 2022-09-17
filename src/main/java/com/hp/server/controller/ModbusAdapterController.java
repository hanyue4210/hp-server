package com.hp.server.controller;

import com.hp.server.aspect.CheckIdentityToken;
import com.hp.server.dto.ModbusAdapterWriteDTO;
import com.hp.server.result.ResultBody;
import com.hp.server.service.ModbusAdapterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author:mengchen
 * @date:2020/6/29
 * @description:ModbusAdapter相关接口
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/modbusAdapter")
public class ModbusAdapterController {
    @Resource
    private ModbusAdapterService modbusAdapterService;


    /**
     * 读数据点：根据设备串码和属性id读取设备的某一个属性的最新值
     * @param deviceCode 设备串码
     * @param resId       属性ID
     * @return
     */
    @CheckIdentityToken
    @GetMapping(value="/readResource")
    public ResultBody readResource(String deviceCode, Integer resId) {
        return new ResultBody(modbusAdapterService.readResource(deviceCode, resId));
    }

    /**
     * 写数据点：根据设备串码和属性id向设备的某一个属性写入新的数据
     * @param dto 请求参数
     * @return
     */
    @CheckIdentityToken
    @PostMapping(value="/writeResource")
    public ResultBody writeResource(@RequestBody ModbusAdapterWriteDTO dto) {
        return modbusAdapterService.writeResource(dto);
    }

    /**
     * 查询请求频率
     * @return
     */
    @CheckIdentityToken
    @GetMapping(value="/getRequestFrequency")
    public ResultBody getRequestFrequency(HttpServletRequest request) {
        String loginName = request.getHeader("loginName");
        return modbusAdapterService.getRequestFrequency(loginName);
    }
}
