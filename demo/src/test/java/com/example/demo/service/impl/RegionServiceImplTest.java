package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Region;
import com.example.demo.service.RegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Auther: sunmingyao
 * @Date: 2018/10/19 16 54
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class RegionServiceImplTest {

    @Autowired
    private RegionService regionService;

    @Test
    public void listRegion() throws Exception {
    }

    @Test
    public void getRegion() throws Exception {

        System.out.println(JSON.toJSONString(regionService.getRegion("A0000641")));

    }
    @Test
    public void updateRegion() throws Exception {

        Region region = new Region();
        region.setId(3491L);
        region.setRegionName("海尔集团1");
        region.setIsActived("Y");
        Integer in = regionService.updateRegion(region);
        System.out.println(in);

    }


}