package com.example.demo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.SybType;
import com.example.demo.entiy.User;
import com.example.demo.service.SybTypeService;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/11 14 35
 * @Description:
 */

@RestController
@RequestMapping("/sybTypeApi")
public class SybTypeApiController {

    @Autowired
    private SybTypeService sybTypeService;

    @Autowired
    private UserService userService;

    @RequestMapping("/listSybType")
    public String listSybType(@RequestParam(value="page") Integer page, @RequestParam(value="limit") Integer limit,@RequestParam(value = "name",required = false) String name){
        PageHelper.startPage(page,limit);
        List<SybType> sybTypeList = sybTypeService.listSybType(name);
        Map<String, Object> sybTypeMap = new HashMap<>();
        PageInfo pages=new PageInfo(sybTypeList,8);
        sybTypeMap.put("code",0);
        sybTypeMap.put("data", pages.getList());
        sybTypeMap.put("msg","");
        sybTypeMap.put("count",pages.getTotal());
        return JSON.toJSONString(sybTypeMap);

    }
    @RequestMapping("/addSybType")
    public String addSybType(HttpServletRequest request, @RequestParam(value = "code") String code, @RequestParam(value = "name") String name){

        User currentUser = userService.getCurrentUser(request);

        SybType sybType = new SybType();
        sybType.setCode(code);
        sybType.setName(name);
        sybType.setOperateTime(new Date());
        sybType.setOperateUser(currentUser.getUserName());
        Map<String, Object> result = new HashMap<>();

        try {
            sybTypeService.addSybType(sybType);
        }catch (Exception e){
            result.put("code","02");
            result.put("message","插入失败！");
            return JSON.toJSONString(result);

        }

        result.put("code","01");
        result.put("message","插入成功！");

        return JSON.toJSONString(result);
    }

    @RequestMapping("/deleteSybType")
    public String deleteSybType(@RequestParam(value="id") String id){

        Map<String, Object> result = new HashMap<>();

        //删除做校验


        String[] ids = id.split("-");

        for(int i=1;i<ids.length;i++){
            SybType currentSybType = sybTypeService.getById(Integer.parseInt(ids[i]));

            if(currentSybType != null){
                sybTypeService.deleteSybType(currentSybType.getId());
            }
        }


        result.put("code", "01");
        result.put("message", "删除成功");

        return JSON.toJSONString(result);
    }
    @RequestMapping("/getSybTypeForSelect")
    public String getSybTypeForSelect(){

        List<SybType> list = sybTypeService.getSybTypeForSelect();
        return JSON.toJSONString(list);
    }


}
