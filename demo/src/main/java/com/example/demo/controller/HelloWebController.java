package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class HelloWebController {



    @RequestMapping("/index")
    public String hello(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        //向模板中添加属性
        return "index";

    }

    @RequestMapping("/index2")
    public String index2(ModelMap modelMap){
        return "user/roleManager";
    }

    @RequestMapping(value="/system/sybType")
    public String sybType(ModelMap modelMap){
        return "system/sybType";
    }

    @RequestMapping(value="/system/syb")
    public String syb(ModelMap modelMap){
        return "system/syb";
    }

    @RequestMapping(value = "/system/dept")
    public String dept(ModelMap modeMap) {
        return "system/dept";
    }

}
