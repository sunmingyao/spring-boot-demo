package com.example.demo.service;

import com.example.demo.entiy.SybType;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/11 13 18
 * @Description:
 */
public interface SybTypeService {

    List<SybType> listSybType(String name);

    int addSybType(SybType sybType);

    SybType getById(Integer id);

    int deleteSybType(Integer id);

    List<SybType> getSybTypeForSelect();
}
