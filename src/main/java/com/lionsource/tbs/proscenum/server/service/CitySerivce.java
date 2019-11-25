package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.City;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 9:48
 * @Version 1.0
 * 城市市
 */
public interface CitySerivce {
    /**
     * 根据省份的id查询所有的城市
     */
    List<City> getAllCity(int provId);
}
