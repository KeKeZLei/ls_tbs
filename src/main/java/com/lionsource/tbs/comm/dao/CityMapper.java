package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.City;
import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    City selectByPrimaryKey(Integer cityId);

    List<City> selectAll();

    int updateByPrimaryKey(City record);
}