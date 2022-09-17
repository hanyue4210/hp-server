package com.hp.server.dao;

import com.hp.server.dto.OperationHistoryDTO;
import com.hp.server.vo.OperationHistoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OperationHistoryMapper {

    /**
     * 分页查询历史数据
     * @param dto
     * @return
     */
    List<OperationHistoryDTO> getOperationHistory(OperationHistoryDTO dto);

    /**
     * 查询历史详情
     * @param dto
     * @return
     */
    List<OperationHistoryVo> getDetail(OperationHistoryDTO dto);

    /**
     * 查询离某个时间点最近的数据
     * @param date
     * @return
     */
    OperationHistoryVo getId(@Param("date") Long date,@Param("deviceCode")String deviceCode);

}
