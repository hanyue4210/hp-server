package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.basicDepartmentDTO;
import com.hp.server.result.ResponseInfoEnum;
import com.hp.server.result.ResultBody;
import com.hp.server.service.DepartmentService;
import com.hp.server.vo.basicDepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hanyue
 * @create 2020-06-28 下午 04:05
 */
@RestController
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    /**
     * 保存*更新部门*删除
     *
     * @param vo
     * @return
     */
    @PostMapping("/save")
    public ResultBody save(@RequestBody @Valid basicDepartmentVo vo) {
        Integer save = service.save(vo);
        if (save == -1) {
            return new ResultBody(ResponseInfoEnum.REPEAT);
        }
        return new ResultBody();
    }

    /**
     * 逻辑删除
     *
     * @param vo
     * @return
     */
    @PostMapping("/del")
    public ResultBody del(@RequestBody @Valid basicDepartmentVo vo) {
        return new ResultBody(service.del(vo));
    }

    /**
     * 获取分页列表 * 查看详情
     *
     * @param dto
     * @return
     */
    @GetMapping("/getLists")
    public ResultBody getLists(@Valid basicDepartmentDTO dto) {
        return new ResultBody(new PageInfo<>(service.getLists(dto)));
    }
}
