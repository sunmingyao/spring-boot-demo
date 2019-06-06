package com.example.demo.service.impl;

import com.example.demo.dao.RegionDao;
import com.example.demo.entiy.Region;
import com.example.demo.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/16 12 24
 * @Description:
 */

@Service("regionService")
public class RegionServiceImpl implements RegionService{

    @Resource
    private RegionDao regionDao;


    @Override
    public List<Region> listRegion() {
        return regionDao.listRegion();
    }

    @Override
    public Region getRegion(String regionCode) {
        return regionDao.getRegion(regionCode);
    }

    @Override
    public int updateRegion(Region region) {
        return regionDao.updateRegion(region);
    }

    @Override
    public int updateParentRegionActive(Integer id) {
        return regionDao.updateParentRegionActive(id);
    }


}
