package com.example.demo.service.impl;

import com.example.demo.dao.ResourceDao;
import com.example.demo.entiy.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 16 11
 * @Description:
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> getResourceListByUserId(Integer id) {
        return resourceDao.getResourceListByUserId(id);
    }
}
