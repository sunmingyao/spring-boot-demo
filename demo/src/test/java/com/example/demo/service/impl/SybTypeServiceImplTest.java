package com.example.demo.service.impl;

import com.example.demo.entiy.SybType;
import com.example.demo.service.SybTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/12 09 38
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class SybTypeServiceImplTest {

    @Autowired
    private SybTypeService sybTypeService;

    @Test
    public void addSybType() {

        SybType sybType = new SybType();
        sybType.setCode("106");
        sybType.setName("测试新");
        sybType.setOperateTime(new Date());
        sybType.setOperateUser("admin");

        sybTypeService.addSybType(sybType);
    }
}