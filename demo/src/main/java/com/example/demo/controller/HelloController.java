package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.annoation.MyInfoAnnotation;
import com.example.demo.entiy.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {


    @Autowired
    private UserService userService;


    @MyInfoAnnotation(value = "FCC")
    @RequestMapping("/hello")
    public String index(@Param(value = "par") String par,@Param(value = "par2") String par2,@Param(value = "sign") String sign){

        if(sign.equals("FALSE")){
            return "签名不正确";
        }

        System.out.printf("k");
        return "Hello World";
    }
    @RequestMapping("/getAllUserData")
    public String getAllUserDate(){


        User user = null;

        List<User> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        map.put("code",0);
        list.add(user);
        map.put("data",list);

        return JSON.toJSONString(map);
    }

}
