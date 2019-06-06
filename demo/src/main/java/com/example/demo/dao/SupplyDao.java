package com.example.demo.dao;

import com.example.demo.entiy.Supply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/7 11 05
 * @Description:
 */
@Mapper
@Repository("supplyDao")
public interface SupplyDao {

    List<Supply> listSupply();
}
