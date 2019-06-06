package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Region;
import com.example.demo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/16 12 38
 * @Description:
 */

@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping("/regionManager")
    public String regionManager(ModelMap modelMap){
        return "baseInformation/regionManager";
    }

}
