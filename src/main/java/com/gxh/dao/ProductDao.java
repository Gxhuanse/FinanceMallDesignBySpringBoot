package com.gxh.dao;

import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.product.ProductSelectPageConditionInDTO;

public interface ProductDao {
    PageDTO selectProductByPageCondition(ProductSelectPageConditionInDTO dto);
}
