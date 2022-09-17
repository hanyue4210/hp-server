package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.ProductMapper;
import com.hp.server.dto.BasicProductDTO;
import com.hp.server.service.ProductService;
import com.hp.server.vo.BasicProductVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanyue
 * @create 2020-06-29 下午 02:19
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductMapper mapper;

    /**
     * 保存产品分类
     *
     * @param vo
     * @return
     */
    @Override
    public Integer save(BasicProductVo vo) {
        if (vo.getIsDeleted() != null) {
            logger.info("删除产品分类");
            return mapper.update(vo);
        }
        BasicProductDTO productDTO = new BasicProductDTO();
        productDTO.setCompanyId(vo.getCompanyId());
        productDTO.setProductType(vo.getProductType());
        List<BasicProductDTO> lists = mapper.getLists(productDTO);
        if (vo.getId() != null) {
            logger.info("更新产品分类");
            if (lists != null && lists.size() > 0) {
                for (BasicProductDTO list : lists) {
                    if (list.getId() != vo.getId()) {
                        return -1;
                    }
                }
            }
            return mapper.update(vo);
        } else {
            logger.info("保存产品分类");
            if (lists != null && lists.size() > 0) {
                return -1;
            }
            return mapper.save(vo);
        }
    }

    /**
     * 分页查询产品分类
     *
     * @param dto
     * @return
     */
    @Override
    public List<BasicProductDTO> getLists(BasicProductDTO dto) {
        if (dto.getBeginRow() != null && dto.getLimitRow() != null) {
            PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        }
        return mapper.getLists(dto);
    }
}
