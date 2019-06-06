package com.example.demo.service;

import com.example.demo.entiy.Roal;

import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 16 09
 * @Description:
 */
public interface RoalService {

    /**
     * <根据用户ID获取用户角色>
     * @Author SunMingyao
     * @Date 2018/11/23 16:13
     * @Company PengHai
     * @Param [id]
     * @Return java.util.List<com.example.demo.entiy.Roal>
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    List<Roal> getRoalListByUserId(Integer id);
}
