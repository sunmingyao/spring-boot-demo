package com.example.demo.dao;

import com.example.demo.entiy.SybType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/11 10 23
 * @Description:
 */
@Mapper
@Repository("sybTypeDao")
public interface SybTypeDao {
    /**
     * <获取所有事业部的列表展示>
     * @Author SunMingyao
     * @Date 2018/12/11 14:38
     * @Company PengHai
     * @Param []
     * @Return java.util.List<com.example.demo.entiy.SybType>
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    List<SybType> listSybType(@Param("name") String name);

    int addSybType(SybType sybType);

    SybType getById(@Param("id") Integer id);

    int deleteSybType(@Param("id") Integer id);
}
