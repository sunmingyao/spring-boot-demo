package com.example.demo.service.impl;

import com.example.demo.dao.DeptDao;
import com.example.demo.entiy.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/25 09 49
 * @Description:
 */

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> listDept(String name, Integer sybCode) {
        return deptDao.listDept(name,sybCode);
    }
}
