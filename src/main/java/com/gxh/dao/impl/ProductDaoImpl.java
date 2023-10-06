package com.gxh.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxh.dao.ProductDao;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.product.ProductSelectPageConditionInDTO;
import com.gxh.entity.dto.product.ProductSelectPageConditionOutDTO;
import com.gxh.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    ProductMapper productMapper;

    @Override
    public PageDTO selectProductByPageCondition(ProductSelectPageConditionInDTO dto) {
        PageDTO pageDto=new PageDTO();

        PageHelper.startPage(dto.getCurr(),dto.getNums());

        List<ProductSelectPageConditionOutDTO> dtoList = productMapper.selectProductByPageCondition(dto);

        PageInfo<ProductSelectPageConditionOutDTO> pageInfo=new PageInfo<>(dtoList);

        pageDto.setCount(pageInfo.getTotal());
        pageDto.setList(pageInfo.getList());
        return pageDto;
    }
}
