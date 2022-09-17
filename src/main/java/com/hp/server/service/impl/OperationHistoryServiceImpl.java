package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.OperationHistoryMapper;
import com.hp.server.dto.OperationHistoryDTO;
import com.hp.server.enumeration.ModeStatus;
import com.hp.server.service.OperationHistoryService;
import com.hp.server.vo.OperationHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OperationHistoryServiceImpl implements OperationHistoryService {

    @Autowired
    OperationHistoryMapper mapper;

    /**
     * 分页查询历史数据
     * @param dto
     * @return
     */
    @Override
    public List<OperationHistoryDTO> getOperationHistory(OperationHistoryDTO dto) {
        PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        return mapper.getOperationHistory(dto);
    }

    /**
     * 查询历史详情
     *
     * @param dto
     * @return
     */
    @Override
    public List<OperationHistoryVo> getDetail(OperationHistoryDTO dto) {
        if (dto.getBeginRow() != null && dto.getLimitRow() != null) {
            PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        }
        List<OperationHistoryVo> list = mapper.getDetail(dto);
        for (OperationHistoryVo item : list) {
            if (item.getModeStatus() != null) {
                // 模块状态处理
                StringBuilder builder3 = new StringBuilder();
                String value = org.apache.commons.lang3.StringUtils.leftPad(Integer.toBinaryString(item.getModeStatus()), 16, "0");
                int a = value.indexOf("1");
                while (a != -1) {
                    builder3.append(ModeStatus.getEnumByKey(a).getMsg() + "\t");

                    a = value.indexOf("1", a + 1);//*从这个索引往后开始第一个出现的位置
                }
                item.setModeStatusName(builder3.toString());
            }

        }
        return list;
    }

    /**
     * 查询离某个时间点最近的数据
     *
     * @param date
     * @param deviceCode
     * @return
     */
    @Override
    public OperationHistoryVo getId(Long date, String deviceCode) {
        return mapper.getId(date,deviceCode);
    }
}
