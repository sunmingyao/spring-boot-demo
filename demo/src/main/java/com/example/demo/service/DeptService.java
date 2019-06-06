package com.example.demo.service;

import com.example.demo.entiy.Dept;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/25 09 49
 * @Description:
 */
public interface DeptService {

    List<Dept> listDept(String name,Integer sybCode);
}
