package com.example.demo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Dept;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/25 09 51
 * @Description:
 */
@RestController
@RequestMapping("/deptApi")
public class DeptApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("/listDept")
    public String listSyb(@RequestParam(value="page") Integer page, @RequestParam(value="limit") Integer limit, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "sybCode",required = false) String sybCode){

        Integer _sybCode = null;

        if(StringUtils.isNotBlank(sybCode)){
            _sybCode = Integer.parseInt(sybCode);
        }

        PageHelper.startPage(page,limit);
        List<Dept> deptList = deptService.listDept(name,_sybCode);
        Map<String, Object> sybMap = new HashMap<>();
        PageInfo pages=new PageInfo(deptList,8);
        sybMap.put("code",0);
        sybMap.put("data", pages.getList());
        sybMap.put("msg","");
        sybMap.put("count",pages.getTotal());
        return JSON.toJSONString(sybMap);
    }

    }
