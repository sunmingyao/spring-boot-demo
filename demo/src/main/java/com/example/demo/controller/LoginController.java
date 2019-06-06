package com.example.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/22 16 47
 * @Description:
 */

@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping("/login")
    public String login(ModelMap modelMap){
        return "login";
    }
}
