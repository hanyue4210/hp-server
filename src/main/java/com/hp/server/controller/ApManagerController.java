package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.ApManagerDTO;
import com.hp.server.result.ResponseInfoEnum;
import com.hp.server.result.ResultBody;
import com.hp.server.service.ApManagerService;
import com.hp.server.vo.ApManagerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hanyue
 * @create 2020-06-30 下午 02:02
 */
@RestController
@RequestMapping("/ApManager")
public class ApManagerController {

    @Autowired
    ApManagerService service;

    /**
     * 保存*更新*删除
     *
     * @param vo
     * @return
     */
    @PostMapping("/save")
    public ResultBody save(@RequestBody @Valid ApManagerVo vo) {
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
    public ResultBody getLists(@Valid ApManagerDTO dto) {
        return new ResultBody(new PageInfo<>(service.getLists(dto)));
    }
}
