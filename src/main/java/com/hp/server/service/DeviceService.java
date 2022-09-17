package com.hp.server.service;

import com.hp.server.dto.DeviceManagerDTO;
import com.hp.server.vo.DeviceManagerVo;

import java.util.List;

public interface DeviceService {
    /**
     * 分页查询设备列表
     *
     * @param vo
     * @return
     */
    List<DeviceManagerVo> getDevice(DeviceManagerDTO vo);

    /**
     * 更新机组设备
     *
     * @param dto
     * @return
     */
    Integer updateDevice(DeviceManagerVo dto);

    /**
     * 逻辑删除机组信息
     *
     * @param id
     * @return
     */
    Integer delDevice(Long id);


    /**
     * 更新设备状态
     * @param imei
     * @param status
     */
    void updateDeviceStatus(String imei, Integer status);
}
