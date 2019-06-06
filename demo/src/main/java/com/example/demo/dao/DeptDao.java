package com.example.demo.dao;

import com.example.demo.entiy.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/25 09 43
 * @Description:
 */
@Mapper
@Repository("deptDao")
public interface DeptDao {
    List<Dept> listDept(@Param("name") String name, @Param("sybCode") Integer sybCode);
}
