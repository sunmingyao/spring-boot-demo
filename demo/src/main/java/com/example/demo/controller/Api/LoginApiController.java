package com.example.demo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.User;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import com.example.demo.utils.ApiCommonResult;
import com.example.demo.utils.Md5;
import com.example.demo.utils.TokenUtil.JWT;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.utils.CookieUtil.getCookieByName;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 09 11
 * @Description:
 */
@RestController
@RequestMapping("/loginApi")
public class LoginApiController {

    private final static Logger logger = LoggerFactory.getLogger(LoginApiController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/login")
    public String login(@Param(value = "userName") String userName, @Param(value = "passWord") String passWord, HttpServletResponse response){

        logger.info("用户登录："+userName);
        ApiCommonResult<Map<String,Object>> result = new ApiCommonResult<>();

        //1、验证用户名和密码
        User loginUser = userService.getByUserName(userName);
        if(!Md5.getMd5String(passWord).equals(loginUser.getPassWord())){
            result.success = false;
            result.setCode("01");
            result.setMessage("密码错误！");
            return JSON.toJSONString(result);
        }

        //2、生成token将用户信息保存到Redis中
        Long currentTimeMillis = System.currentTimeMillis();
        String token = JWT.sign(loginUser, 3600L * 1000L,currentTimeMillis);//一小时
        if (token != null) {
            logger.info("生成的token为："+token);
            redisService.setWithTime("USER_TOKEN_"+token,token,3600L * 1000L);
        }


        //3、写入Cookie
        Cookie cookie = new Cookie("UserToken",token);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        //4、读取用户权限

        result.setCode("10");
        result.setMessage("登录成功");

        Map<String, Object> data = new HashMap<>();
        data.put("auth",null);
        return JSON.toJSONString(result);

    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request){
        logger.info("用户注销：");
        ApiCommonResult<Map<String,Object>> result = new ApiCommonResult<>();

        //清除Redis的userToken
        Cookie cookie = getCookieByName(request, "UserToken");

        if(cookie != null){
            redisService.remove("USER_TOKEN_" + cookie.getValue().toString());
        }


    }
}
