package com.example.demo.service;

import com.example.demo.entiy.Syb;
import com.example.demo.entiy.SybType;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/12 14 33
 * @Description:
 */
public interface SybService {
    List<Syb> listSyb(String name,Integer sybTypeCode);

     int addSyb(Syb syb);

     int deleteSyb(Integer id);

     Syb getById(Integer id);

     List<Syb> getSybForSelect();
}
