package com.example.demo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Resource;
import com.example.demo.entiy.Roal;
import com.example.demo.entiy.User;
import com.example.demo.service.ResourceService;
import com.example.demo.service.RoalService;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 16 00
 * @Description:
 */
@RestController
@RequestMapping("/userApi")
public class UserApiController  {

    @Autowired
    private UserService userService;

    @Autowired
    private RoalService roalService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/resourceList")
    public String getCurrentUserInfo(HttpServletRequest request){

        //1、用户信息
        User currentUser = userService.getCurrentUser(request);

        //2、用户角色
//        List<Roal> roalList = roalService.getRoalListByUserId(currentUser.getId());

        //3、权限
        List<Resource> resourceList = resourceService.getResourceListByUserId(currentUser.getId());




        return JSON.toJSONString(resourceList);
    }

    /**
     * <说明>
     * @author SunMingyao
     * @date 2019/3/1 10:48
     * @company PengHai
     * @params [pages, limit]
     * @return java.lang.String
     * @see [相关类/方法]
     * @since [产品/模块版本]
     */
    @RequestMapping("/listUserInformation")
    public String listUserInformation(@RequestParam(value="page") Integer page,@RequestParam(value="limit") Integer limit){

        PageHelper.startPage(page,limit);
        List<User> userList = userService.listUserInformation();
        Map<String, Object> userMap = new HashMap<>();
        PageInfo pages=new PageInfo(userList,8);
        userMap.put("code",0);
        userMap.put("data", pages.getList());
        userMap.put("msg","");
        userMap.put("count",pages.getTotal());

        return JSON.toJSONString(userMap);
    }


}
