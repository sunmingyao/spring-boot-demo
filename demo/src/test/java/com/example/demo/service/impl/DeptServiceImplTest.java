package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Dept;
import com.example.demo.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/25 10 00
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class DeptServiceImplTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void listDept() {

       List<Dept> depts = deptService.listDept(null,null);
        System.out.println(JSON.toJSONString(depts));
    }
}