package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Region;
import com.example.demo.service.RegionService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/19 15 14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class Temp {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RegionService regionService;

    @Test
    public void unActiveRegion(){

        List<Region> list = regionService.listRegion();
        Region currentRegion = null;

        //获取当前的Region
        for(Region region : list){
            if(region.getRegionItem() == null){
                region.setRegionItem(new ArrayList<Region>());
            }
            if (region.getRegionCode().equals("A0000644")) {
                currentRegion = region;
            }

            if(true){
                for(Region j : list){
                    if(j.getParentId().intValue() == region.getId()){
                        region.getRegionItem().add(j);
                    }
                }
            }

        }

        List<Region> r = new ArrayList<>();
        r.add(currentRegion);

        Boolean flag ;


        do{

            flag = true;
            for(int i=0;i<r.size();i++){
                if(r.get(i).getRegionItem() != null){
                    r.addAll(r.get(i).getRegionItem());
                    r.get(i).setRegionItem(null);
                    flag =false;
                }
            }

        }while (flag == true);


        System.out.println(JSON.toJSONString(r));

    }

    @Test
    public void testKafka(){



        for(int i=0;i<20;i++) {

            kafkaTemplate.send("test-topic", "hello", i+"");
        }

        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
