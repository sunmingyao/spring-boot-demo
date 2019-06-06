package com.example.demo.dao;

import com.example.demo.entiy.Syb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/12 14 30
 * @Description:
 */

@Mapper
@Repository("sybDao")
public interface SybDao {

    List<Syb> listSyb(@Param("name") String name,@Param("sybTypeCode") Integer sybTypeCode);

    int addSyb(Syb syb);

    int deleteSyb(@Param("id") Integer id);

    Syb getById(@Param("id") Integer id);
}
