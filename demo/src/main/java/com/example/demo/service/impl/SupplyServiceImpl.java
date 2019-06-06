package com.example.demo.service.impl;

import com.example.demo.dao.SupplyDao;
import com.example.demo.entiy.Supply;
import com.example.demo.service.SupplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/7 11 18
 * @Description:
 */
@Service("supplyService")
public class SupplyServiceImpl implements SupplyService {

    @Resource
    private SupplyDao supplyDao;

    @Override
    public List<Supply> listSupply() {
        return supplyDao.listSupply();
    }
}
