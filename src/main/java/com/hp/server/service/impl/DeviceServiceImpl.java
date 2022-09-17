package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.DeviceManagerMapper;
import com.hp.server.dto.DeviceManagerDTO;
import com.hp.server.service.DeviceService;
import com.hp.server.vo.DeviceManagerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceManagerMapper mapper;

    /**
     * 分页查询设备列表
     *
     * @param vo
     * @return
     */
    @Override
    public List<DeviceManagerVo> getDevice(DeviceManagerDTO vo) {
        if (vo.getBeginRow() != null && vo.getLimitRow() != null) {
            PageHelper.offsetPage(vo.getBeginRow(), vo.getLimitRow());
        }
        List<DeviceManagerVo> device = mapper.getDevice(vo);
        if (device != null && device.size() > 0) {
            for (DeviceManagerVo managerVo : device) {
                if (managerVo.getRegion() != null) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(managerVo.getRegion());
                    if (managerVo.getTower() != null) {
                        builder.append("/" + managerVo.getTower());
                    }
                    if (managerVo.getCell() != null) {
                        builder.append("/" + managerVo.getCell());
                    }
                    managerVo.setCommunity(builder.toString());
                } else {
                    managerVo.setCommunity("--");
                }
                if (managerVo.getGroups() != null) {
                    StringBuilder builder2 = new StringBuilder();
                    builder2.append(managerVo.getGroups());
                    if (managerVo.getSite() != null) {
                        builder2.append("/" + managerVo.getSite());
                    }
                    if (managerVo.getUnit() != null) {
                        builder2.append("/" + managerVo.getUnit());
                    }
                    managerVo.setUnitInfor(builder2.toString());
                } else {
                    managerVo.setUnitInfor("--");
                }
            }
        }
        return device;
    }

    /**
     * 更新机组设备
     *
     * @param dto
     * @return
     */
    @Override
    public Integer updateDevice(DeviceManagerVo dto) {
        if (dto.getTowerId() != null) {
            dto.setRegionId(String.valueOf(mapper.getRegionId(Long.valueOf(dto.getTowerId()))));
        }
        if (dto.getCellId() != null) {
            dto.setTowerId(String.valueOf(mapper.getTowerId(Long.valueOf(dto.getCellId()))));
            dto.setRegionId(String.valueOf(mapper.getRegionId(Long.valueOf(dto.getTowerId()))));
        }

        if (dto.getSiteId() != null) {
            dto.setGroupId(String.valueOf(mapper.getGroupId(Long.valueOf(dto.getSiteId()))));
        }

        if (dto.getUnitId() != null) {
            dto.setSiteId(String.valueOf(mapper.getSiteId(Long.valueOf(dto.getUnitId()))));
            dto.setGroupId(String.valueOf(mapper.getGroupId(Long.valueOf(dto.getSiteId()))));
        }
        if (dto.getId() == null) {
            return mapper.saveDevice(dto);
        }
        return mapper.updateDevice(dto);
    }

    /**
     * 逻辑删除机组信息
     *
     * @param id
     * @return
     */
    @Override
    public Integer delDevice(Long id) {
        return mapper.delDevice(id);
    }

    /**
     * 更新设备状态
     *
     * @param imei
     * @param status
     */
    @Override
    public void updateDeviceStatus(String imei, Integer status) {
        mapper.updateDeviceStatus(imei, status);
    }


}
