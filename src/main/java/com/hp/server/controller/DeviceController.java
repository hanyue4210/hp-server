package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.DeviceManagerDTO;
import com.hp.server.result.ResultBody;
import com.hp.server.service.DeviceService;
import com.hp.server.vo.DeviceManagerVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager")
public class DeviceController {

    @Autowired
    DeviceService service;

    /**
     * 分页查询设备列表
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:device:device")
    @GetMapping("/get/device")
    public ResultBody getDevice(@Valid DeviceManagerDTO vo) {
        return new ResultBody(new PageInfo<>(service.getDevice(vo)));
    }

    /**
     * 更新机组设备
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:device:device:setup")
    @PostMapping("/update/device")
    public ResultBody updateDevice(@RequestBody @Valid DeviceManagerVo dto) {
        ResultBody resultBody = new ResultBody();
        Integer integer = service.updateDevice(dto);
        if (integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除机组信息
     *
     * @param id
     * @return
     */
    @PostMapping("/del/device")
    public ResultBody delDevice(@RequestParam("id") Long id) {
        ResultBody resultBody = new ResultBody();
        Integer integer = service.delDevice(id);
        if (integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        return resultBody;
    }
}
