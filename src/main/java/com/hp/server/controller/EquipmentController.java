package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.BasicEquipmentDTO;
import com.hp.server.result.ResponseInfoEnum;
import com.hp.server.result.ResultBody;
import com.hp.server.service.EquipmentService;
import com.hp.server.vo.BasicEquipmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hanyue
 * @create 2020-06-29 上午 10:22
 */
@RestController
@RequestMapping("/Equipment")
public class EquipmentController {
    @Autowired
    EquipmentService service;

    /**
     * 保存*更新*删除
     *
     * @param vo
     * @return
     */
    @PostMapping("/save")
    public ResultBody save(@RequestBody @Valid BasicEquipmentVo vo) {
        Integer save = service.save(vo);
        if (save == -1) {
            return new ResultBody(ResponseInfoEnum.REPEAT);
        }
        return new ResultBody();
    }

    /**
     * 获取分页列表 * 查看详情
     *
     * @param dto
     * @return
     */
    @GetMapping("/getLists")
    public ResultBody getLists(@Valid BasicEquipmentDTO dto) {
        return new ResultBody(new PageInfo<>(service.getLists(dto)));
    }
}
