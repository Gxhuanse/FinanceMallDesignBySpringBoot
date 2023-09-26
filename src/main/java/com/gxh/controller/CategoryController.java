package com.gxh.controller;


import com.gxh.common.ResponseBean;
import com.gxh.entity.Category;
import com.gxh.entity.UserBean;
import com.gxh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author gxhuanse
 * @since 2023-09-26
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/AddCategory")
    public ResponseBean AddCategory(Category category){
        ResponseBean responseBean=null;
        try {
            if (true){

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

