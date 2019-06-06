package com.example.demo.dao;

import com.example.demo.entiy.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 09 38
 * @Description:
 */
@Mapper
@Repository("userDao")
public interface UserDao {

    User getByUserName(@Param("userName") String userName);

    List<User> listUserInformation();
}
