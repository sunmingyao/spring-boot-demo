package com.example.demo.service;

import com.example.demo.entiy.Region;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/16 12 23
 * @Description:
 */
public interface RegionService {

    List<Region> listRegion();

    /**
     * <根据大区编码返回大区信息>
     * @Author SunMingyao
     * @Date 2018/10/19 16:51
     * @Company PengHai
     * @Param [regionCode]
     * @Return com.example.demo.entiy.Region
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    Region getRegion(String regionCode);

    /**
     * <更新区域信息>
     * @Author SunMingyao
     * @Date 2018/10/19 17:07
     * @Company PengHai
     * @Param [region]
     * @Return int
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    int updateRegion(Region region);

    /**
     * <更新父级大区为可用状态>
     * @Author SunMingyao
     * @Date 2018/11/5 10:44
     * @Company PengHai
     * @Param []
     * @Return int
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    int updateParentRegionActive(Integer id);
}
