package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.DeviceManagerDTO;
import com.hp.server.dto.OperationHistoryDTO;
import com.hp.server.result.ResultBody;
import com.hp.server.service.DeviceService;
import com.hp.server.service.OperationHistoryService;
import com.hp.server.vo.OperationHistoryVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/history")
public class OperationHistoryController {

    @Autowired
    OperationHistoryService service;

    @Autowired
    DeviceService deviceServiceservice;

    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 分页查询设备列表
     *
     * @param vo
     * @return
     */
    @GetMapping("/get/OperationHistor")
    public ResultBody getDevice(@Valid DeviceManagerDTO vo) {
        return new ResultBody(new PageInfo<>(deviceServiceservice.getDevice(vo)));
    }


    /**
     * 分页查询历史数据
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:history:info:ViewHistoricalDetails")
    @GetMapping("/getDetail")
    public ResultBody getDetail(OperationHistoryDTO dto) {
        List<OperationHistoryVo> detail = service.getDetail(dto);
        for (OperationHistoryVo historyVo : detail) {
            historyVo.setCreateTimes(historyVo.getCreateTime().getTime());
        }
        return new ResultBody(new PageInfo<>(detail));
    }

    /**
     * 历史详情折线图
     *
     * @param dto
     * @return
     */
    @GetMapping("/getDatas")
    public ResultBody getDatas(OperationHistoryDTO dto) {
        ArrayList<OperationHistoryVo> list = new ArrayList<>();
        ArrayList<Date> dateList = new ArrayList<>();
        dateList.add(new Date(dto.getStartTime()));
        long time = dto.getStartTime();
        long time1 = dto.getEndTime();
        long l = (time1 - time) / dto.getDataPoint();
        for (int i = 1; i < dto.getDataPoint() - 1; i++) {
            long l1 = time + i * l;
            dateList.add(new Date(l1));
        }
        dateList.add(new Date(dto.getEndTime()));
        for (Date date : dateList) {
            OperationHistoryVo historyVo = service.getId(date.getTime(), dto.getDeviceCode());
            historyVo.setCreateTime(date);
            if (historyVo != null) {
                list.add(historyVo);
            }
        }
        ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<>(10);
        HashMap<String, Object> hashMap1 = new HashMap<>(5);
        ArrayList<Object> list11 = new ArrayList<>();
        ArrayList<Object> list12 = new ArrayList<>();
        hashMap1.put("name", "进水温度");
        hashMap1.put("type", "line");
        hashMap1.put("data", list11);
        hashMap1.put("time", list12);
        HashMap<String, Object> hashMap2 = new HashMap<>(5);
        ArrayList<Object> list21 = new ArrayList<>();
        hashMap2.put("name", "回水温度");
        hashMap2.put("type", "line");
        hashMap2.put("data", list21);
        hashMap2.put("time", list12);
        HashMap<String, Object> hashMap3 = new HashMap<>(5);
        ArrayList<Object> list31 = new ArrayList<>();
        hashMap3.put("name", "进水压力");
        hashMap3.put("type", "line");
        hashMap3.put("data", list31);
        hashMap3.put("time", list12);
        HashMap<String, Object> hashMap4 = new HashMap<>(5);
        ArrayList<Object> list41 = new ArrayList<>();
        hashMap4.put("name", "回水压力");
        hashMap4.put("type", "line");
        hashMap4.put("data", list41);
        hashMap4.put("time", list12);
        HashMap<String, Object> hashMap5 = new HashMap<>(5);
        ArrayList<Object> list51 = new ArrayList<>();
        hashMap5.put("name", "目标值");
        hashMap5.put("type", "line");
        hashMap5.put("data", list51);
        hashMap5.put("time", list12);
        HashMap<String, Object> hashMap6 = new HashMap<>(5);
        ArrayList<Object> list61 = new ArrayList<>();
        hashMap6.put("name", "实际值");
        hashMap6.put("type", "line");
        hashMap6.put("data", list61);
        hashMap6.put("time", list12);
        HashMap<String, Object> hashMap7 = new HashMap<>(5);
        ArrayList<Object> list71 = new ArrayList<>();
        hashMap7.put("name", "发电电压");
        hashMap7.put("type", "line");
        hashMap7.put("data", list71);
        hashMap7.put("time", list12);
        HashMap<String, Object> hashMap8 = new HashMap<>(5);
        ArrayList<Object> list81 = new ArrayList<>();
        hashMap8.put("name", "电池电压");
        hashMap8.put("type", "line");
        hashMap8.put("data", list81);
        hashMap8.put("time", list12);
        if (list != null && list.size() > 0) {
            for (OperationHistoryVo vo : list) {
                list12.add(vo.getCreateTime().getTime());
                list11.add(vo.getEnteringWaterTemp());
                list21.add(vo.getReturnWaterTemp());
                list31.add(vo.getEnteringWaterPress());
                list41.add(vo.getReturnWaterPress());
                list51.add(vo.getTargetValue());
                list61.add(vo.getActualValue());
                list71.add(vo.getGeneratingVoltage());
                list81.add(vo.getBatteryVoltage());
            }
        }
        hashMaps.add(hashMap1);
        hashMaps.add(hashMap2);
        hashMaps.add(hashMap3);
        hashMaps.add(hashMap4);
        hashMaps.add(hashMap5);
        hashMaps.add(hashMap6);
        hashMaps.add(hashMap7);
        hashMaps.add(hashMap8);
        System.out.println("hashMap8 = " + hashMap8.size());
        System.out.println("hashMaps = " + hashMaps.size());
        return new ResultBody(hashMaps);
    }
}
