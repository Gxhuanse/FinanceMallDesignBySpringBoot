package com.gxh.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gxh.entity.Category;
import com.gxh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ModelData")
public class ModelDataController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/categoryUpdata/{id}")
    public String categoryUpdataById(Model model, @PathVariable Integer id){
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Category::getId,id);
        List<Category> list = categoryService.list(wrapper);
        model.addAttribute("category",list);
        return "category/categoryUpdataModel";
    }

}
