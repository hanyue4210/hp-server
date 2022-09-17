package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.BasicProductDTO;
import com.hp.server.result.ResponseInfoEnum;
import com.hp.server.result.ResultBody;
import com.hp.server.service.ProductService;
import com.hp.server.vo.BasicProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author hanyue
 * @create 2020-06-29 下午 02:24
 */
@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    ProductService service;

    /**
     * 保存*更新*删除
     *
     * @param vo
     * @return
     */
    @PostMapping("/save")
    public ResultBody save(@RequestBody @Valid BasicProductVo vo) {
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
    public ResultBody getLists(@Valid BasicProductDTO dto) {
        return new ResultBody(new PageInfo<>(service.getLists(dto)));
    }
}
