package com.example.demo.service.impl;

import com.example.demo.dao.SybTypeDao;
import com.example.demo.entiy.SybType;
import com.example.demo.service.SybTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/11 13 18
 * @Description:
 */

@Service("sybTypeService")
public class SybTypeServiceImpl implements SybTypeService {

    @Autowired
    private SybTypeDao sybTypeDao;

    @Override
    public List<SybType> listSybType(String name) {
        return sybTypeDao.listSybType(name);
    }

    @Override
    public int addSybType(SybType sybType) {
        return sybTypeDao.addSybType(sybType);
    }

    @Override
    public SybType getById(Integer id) {
        return sybTypeDao.getById(id);
    }

    @Override
    public int deleteSybType(Integer id) {
        return sybTypeDao.deleteSybType(id);
    }

    @Override
    public List<SybType> getSybTypeForSelect() {
        return sybTypeDao.listSybType(null);
    }


}
