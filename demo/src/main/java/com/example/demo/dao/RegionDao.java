package com.example.demo.dao;

import com.example.demo.entiy.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/16 12 22
 * @Description:
 */
@Mapper
@Repository("regionDao")
public interface RegionDao {

    List<Region> listRegion();

    Region getRegion(@Param("regionCode") String regionCode);

    int updateRegion(Region region);

    int updateParentRegionActive(Integer id);
}
