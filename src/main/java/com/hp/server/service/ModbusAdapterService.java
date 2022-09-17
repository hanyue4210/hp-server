package com.hp.server.service;

import com.hp.server.dto.ModbusAdapterWriteDTO;
import com.hp.server.result.ResultBody;

public interface ModbusAdapterService {
    /**
     * 读数据点：根据设备串码和属性id读取设备的某一个属性的最新值
     * @param deviceCode 设备串码
     * @param resId       属性ID
     * @return
     */
    Integer readResource(String deviceCode, Integer resId);

    /**
     * 写数据点：根据设备串码和属性id向设备的某一个属性写入新的数据
     * @param dto 请求参数
     * @return
     */
    ResultBody writeResource(ModbusAdapterWriteDTO dto);

    /**
     * 查询请求频率
     * @param loginName 用户名
     * @return
     */
    ResultBody getRequestFrequency(String loginName);
}
