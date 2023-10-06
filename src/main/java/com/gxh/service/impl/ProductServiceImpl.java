package com.gxh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxh.dao.ProductDao;
import com.gxh.entity.Product;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.product.ProductSelectPageConditionInDTO;
import com.gxh.entity.dto.product.ProductSelectPageConditionOutDTO;
import com.gxh.mapper.ProductMapper;
import com.gxh.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public PageDTO selectProductByPageCondition(ProductSelectPageConditionInDTO dto) {
        return productDao.selectProductByPageCondition(dto);
    }

    @Override
    public int updataStatus(Product product) {
        return 0;
    }
}
