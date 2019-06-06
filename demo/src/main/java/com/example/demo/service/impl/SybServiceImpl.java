package com.example.demo.service.impl;

import com.example.demo.dao.SybDao;
import com.example.demo.entiy.Syb;
import com.example.demo.service.SybService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/12 14 33
 * @Description:
 */
@Service("sybService")
public class SybServiceImpl implements SybService {

    @Autowired
    private SybDao sybDao;

    @Override
    public List<Syb> listSyb(String name,Integer sybTypeCode) {
        return sybDao.listSyb(name,sybTypeCode);
    }

    @Override
    public int addSyb(Syb syb) {
        return sybDao.addSyb(syb);
    }

    @Override
    public int deleteSyb(Integer id) {
        return sybDao.deleteSyb(id);
    }

    @Override
    public Syb getById(Integer id) {
        return sybDao.getById(id);
    }

    @Override
    public List<Syb> getSybForSelect() {
        return sybDao.listSyb(null,null);
    }


}
