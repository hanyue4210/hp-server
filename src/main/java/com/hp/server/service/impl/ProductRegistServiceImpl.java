package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.ProductRegistMapper;
import com.hp.server.dto.ProductRegistDTO;
import com.hp.server.service.ProductRegistService;
import com.hp.server.vo.ProductRegistVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 03:09
 */
@Service
public class ProductRegistServiceImpl implements ProductRegistService {
    private static Logger logger = LoggerFactory.getLogger(ProductRegistServiceImpl.class);

    @Autowired
    ProductRegistMapper mapper;
    /**
     * 保存产品登记
     *
     * @param vo
     * @return
     */
    @Override
    public Integer save(ProductRegistVo vo) {
        if (vo.getIsDeleted() != null) {
            logger.info("删除产品登记");
            return mapper.update(vo);
        }
        ProductRegistDTO productDTO = new ProductRegistDTO();
        productDTO.setCompanyId(vo.getCompanyId());
        //不可重复条件
//        productDTO.setProductType(vo.getProductType());
        List<ProductRegistDTO> lists = mapper.getLists(productDTO);
        if (vo.getId() != null) {
            logger.info("更新产品登记");
            if (lists != null && lists.size() > 0) {
                for (ProductRegistDTO list : lists) {
                    if (list.getId() != vo.getId()) {
                        return -1;
                    }
                }
            }
            return mapper.update(vo);
        } else {
            logger.info("保存产品登记");
            if (lists != null && lists.size() > 0) {
                return -1;
            }
            return mapper.save(vo);
        }
    }

    /**
     * 分页查询产品登记
     *
     * @param dto
     * @return
     */
    @Override
    public List<ProductRegistDTO> getLists(ProductRegistDTO dto) {
        if (dto.getBeginRow() != null && dto.getLimitRow() != null) {
            PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        }
        return mapper.getLists(dto);
    }
}
