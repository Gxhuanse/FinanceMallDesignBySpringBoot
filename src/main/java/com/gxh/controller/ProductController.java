package com.gxh.controller;


import com.gxh.common.ResponseBean;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.product.ProductSelectPageConditionInDTO;
import com.gxh.service.IProductService;
import com.gxh.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-27
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping("/selectByPageCondition")
    public ResponseBean selectByPageCondition(ProductSelectPageConditionInDTO dto){
        ResponseBean responseBean;
        PageDTO pageInfo = null;
        try {
            pageInfo = productService.selectProductByPageCondition(dto);
            responseBean= ResponseBean.ok(0,pageInfo);
        } catch (Exception e) {
            responseBean=ResponseBean.failed("查询失败");
            throw new RuntimeException(e);
        }
        return responseBean;
    }

}

