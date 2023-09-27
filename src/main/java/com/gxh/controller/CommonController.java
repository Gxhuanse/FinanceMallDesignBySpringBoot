package com.gxh.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gxh.entity.Category;
import com.gxh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Common")
public class CommonController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/login")
    public String userlogin(){
        return "/AdmUserLogin";
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/Common/login";
    }

    @RequestMapping("/AdmNavHome")
    public String navHome(){
        return "home/AdmNavHome";
    }

    @RequestMapping("/NavIndex")
    public String NavIndex(){
        return "home/NavIndex";
    }
    @RequestMapping("/About")
    public String About(){
        return "home/About";
    }

    @RequestMapping("/userList")
    public String userList(){
        return "user/userList";
    }

    @RequestMapping("/userPass")
    public String userPass(){
        return "user/userPass";
    }

    @RequestMapping("/userAdd")
    public String userAdd(){
        return "user/userAdd";
    }

    @RequestMapping("/userinfo")
    public String userinfo(){
        return "user/userinfo";
    }

    @RequestMapping("/categoryList")
    public String categoryList(){
        return "category/categoryList";
    }

    @RequestMapping("/categoryAdd")
    public String categoryAdd(){
        return "category/categoryAdd";
    }

    @RequestMapping("/categoryUpdata")
    public String categoryUpdata(){
        return "category/categoryUpdata";
    }

    @RequestMapping("/categoryUpdata/{id}")
    public String categoryUpdataById(Model model, @PathVariable Integer id){
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Category::getId,id);
        List<Category> list = categoryService.list(wrapper);
        model.addAttribute("category",list);
        return "category/categoryUpdataModel";
    }

    @RequestMapping("/productList")
    public String productList(){
        return "product/productList";
    }

    @RequestMapping("/productAdd")
    public String productAdd(){
        return "product/productAdd";
    }


}
