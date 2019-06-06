package com.example.demo.service.impl;

import com.example.demo.dao.RoalDao;
import com.example.demo.entiy.Roal;
import com.example.demo.service.RoalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 16 10
 * @Description:
 */
@Service("roalService")
public class RoalServiceImpl implements RoalService {

    private final static Logger logger = LoggerFactory.getLogger(RoalServiceImpl.class);

    @Autowired
    private RoalDao roalDao;

    @Override
    public List<Roal> getRoalListByUserId(Integer id) {
        return roalDao.getRoalListByUserId(id);
    }
}