package com.example.demo.dao;

import com.example.demo.entiy.Roal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 16 07
 * @Description:
 */
@Mapper
@Repository("roalDao")
public interface RoalDao {

    List<Roal> getRoalListByUserId(@Param("id") Integer id);
}
