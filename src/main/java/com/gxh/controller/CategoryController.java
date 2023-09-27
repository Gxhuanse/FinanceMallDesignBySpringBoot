package com.gxh.controller;


import com.gxh.common.ResponseBean;
import com.gxh.entity.Category;
import com.gxh.entity.dto.PageDTO;
import com.gxh.entity.dto.category.CategorySeletPageConditionDTO;
import com.gxh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-26
 */
@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    ICategoryService service;

    @RequestMapping("/selectByPageCondition")
    public ResponseBean selectByByPageCondition(CategorySeletPageConditionDTO dto){
        ResponseBean responseBean;
        PageDTO pageInfo = null;
        try {
            pageInfo = service.selectIserByPageUseCondition(dto);
            responseBean= ResponseBean.ok(0,pageInfo);
        } catch (Exception e) {
            responseBean=ResponseBean.failed("查询失败");
            throw new RuntimeException(e);
        }
        return responseBean;
    }

    @RequestMapping("/selectCategoryByParentId/{id}")
    public ResponseBean selectCategoryByParentId(@PathVariable Integer id){
        ResponseBean responseBean;
        try {
            List<Category> categoryList = service.selectCategoryByParentId(id);
            responseBean= ResponseBean.ok(0,categoryList);
        } catch (Exception e) {
            responseBean=ResponseBean.failed("查询失败");
            throw new RuntimeException(e);
        }
        return responseBean;
    }

    @RequestMapping("/selectByByPageConditionAndParentName")
    public ResponseBean selectByByPageConditionAndParentName(CategorySeletPageConditionDTO dto){
        ResponseBean responseBean;
        PageDTO pageInfo = null;
        try {
            pageInfo = service.selectByByPageConditionAndParentName(dto);
            responseBean= ResponseBean.ok(0,pageInfo);
        } catch (Exception e) {
            responseBean=ResponseBean.failed("查询失败");
            throw new RuntimeException(e);
        }
        return responseBean;
    }

    @RequestMapping("/categoryAdd")
    public ResponseBean AddCategory(Category category){
        ResponseBean responseBean=null;
        try {
            boolean save = service.save(category);
            if (save){
                responseBean=ResponseBean.ok("添加成功");
            }
            else responseBean=ResponseBean.failed("添加失败");
        } catch (Exception e) {
            responseBean=ResponseBean.failed("添加失败err");
            throw new RuntimeException(e);
        }
        return responseBean;
    }

}

