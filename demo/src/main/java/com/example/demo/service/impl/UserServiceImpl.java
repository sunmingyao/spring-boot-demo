package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entiy.User;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import com.example.demo.utils.TokenUtil.JWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.example.demo.utils.CookieUtil.getCookieByName;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 09 44
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisService redisService;

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    @Override
    public User getCurrentUser(HttpServletRequest request) {

        Cookie cookie = getCookieByName(request, "UserToken");

        User user = null;

        if(cookie != null){
           user = JWT.unsign(cookie.getValue(), User.class);
        }
        return user;
    }

    @Override
    public List<User> listUserInformation() {
        return userDao.listUserInformation();
    }

}
