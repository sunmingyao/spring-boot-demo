package com.example.demo.dao;

import com.example.demo.entiy.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 16 08
 * @Description:
 */
@Mapper
@Repository("resourceDao")
public interface ResourceDao {

    /**
     * <根据用户ID获取权限列表>
     * @Author SunMingyao
     * @Date 2018/11/26 11:20
     * @Company PengHai
     * @Param [id]
     * @Return java.util.List<com.example.demo.dao.Resource>
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    List<Resource> getResourceListByUserId(@Param("id") Integer id);


}
