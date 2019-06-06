package com.example.demo.service;

import com.example.demo.entiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 09 43
 * @Description:
 */
public interface UserService {
    /**
     * <根据用户名获取用户信息>
     * @Author SunMingyao
     * @Date 2018/11/23 09:50
     * @Company PengHai
     * @Param [userName]
     * @Return com.example.demo.entiy.User
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    User getByUserName(String userName);

    /**
     * <根据当前访问用户>
     * @Author SunMingyao
     * @Date 2018/11/23 15:54
     * @Company PengHai
     * @Param [request]
     * @Return com.example.demo.entiy.User
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    User getCurrentUser(HttpServletRequest request);

    List<User> listUserInformation();
}
