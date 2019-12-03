package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.County;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/2 0002 上午 9:06
 * @Version 1.0
 * 区县
 */
public interface CountyService {
    /**
     * 根据市的id查询所有的区县
     */
    List<County> getAllCounty(int city_id);
}
