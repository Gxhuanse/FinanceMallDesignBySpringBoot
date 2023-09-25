package com.gxh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Common")
public class CommonController {

    //http://localhost/BootStart/Common/login
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

    @RequestMapping("/userList")
    public String userList(){
        return "user/userList";
    }


    @RequestMapping("/NavIndex")
    public String NavIndex(){
        return "home/NavIndex";
    }
}
