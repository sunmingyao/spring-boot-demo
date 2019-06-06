package com.example.demo.filter;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.User;
import com.example.demo.service.RedisService;
import com.example.demo.utils.TokenUtil.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.utils.CookieUtil.getCookieByName;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/22 10 51
 * @Description:
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie cookie = getCookieByName(request, "UserToken");

        if(cookie != null) {
            Object objectToken = redisService.get("USER_TOKEN_" + cookie.getValue());

            String token = "";
            if(objectToken != null){
                token = objectToken.toString();
            }
           if(token != null && JWT.unsign(token, User.class) != null && !StringUtils.isEmpty(token)) {

               return super.preHandle(request,response,handler);
           }else if(JWT.unsign(token,User.class) == null){
               //失效了移除Redis端的tokens
               redisService.remove("USER_TOKEN_"+cookie.getValue());
           }
        }
        response.sendRedirect("/login");
        return false;
    }


}
