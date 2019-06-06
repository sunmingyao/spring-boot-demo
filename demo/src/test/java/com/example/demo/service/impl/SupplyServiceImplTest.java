package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Supply;
import com.example.demo.service.SupplyService;
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
 * @Date: 2018/11/7 11 37
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class SupplyServiceImplTest {

    @Autowired
    private SupplyService supplyService;

    @Test
    public void listSupply() {
       List<Supply> supplyList = supplyService.listSupply();
        System.out.println(JSON.toJSONString(supplyList));
    }
}