package com.hp.server.dao;

import com.hp.server.dto.DeviceManagerDTO;
import com.hp.server.vo.DeviceManagerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeviceManagerMapper {
    /**
     * 分页查询设备列表
     * @param vo
     * @return
     */
    List<DeviceManagerVo> getDevice(DeviceManagerDTO vo);

    /**
     * 更新机组设备
     * @param dto
     * @return
     */
    Integer updateDevice(DeviceManagerVo dto);
    /**
     * 保存机组设备
     * @param dto
     * @return
     */
    Integer saveDevice(DeviceManagerVo dto);

    /**
     * 逻辑删除机组信息
     * @param id
     * @return
     */
    Integer delDevice(Long id);

    /**
     * 获取关联小区id
     * @param towerId
     * @return
     */
    Long getRegionId(Long towerId);

    /**
     * 查询关联楼宇id
     * @param cellId
     * @return
     */
    Long getTowerId(Long cellId);

    /**
     * 查询关联分组id
     * @param siteId
     * @return
     */
    Long getGroupId(Long siteId);

    /**
     * 关联查询热换站id
     * @param unitId
     * @return
     */
    Long getSiteId(Long unitId);

    /**
     * 更新设备状态
     * @param imei
     * @param status
     */
    void updateDeviceStatus(@Param("imei") String imei, @Param("status") Integer status);

    /**
     * 根据imei查询设备信息
     * @param imei
     * @return
     */
    DeviceManagerVo getDeviceByImei(String imei);
}
