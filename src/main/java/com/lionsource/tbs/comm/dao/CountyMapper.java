package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.City;
import com.lionsource.tbs.comm.model.County;
import java.util.List;

public interface CountyMapper {
    int deleteByPrimaryKey(Integer counId);

    int insert(County record);

    County selectByPrimaryKey(Integer counId);

    List<County> selectAll();

    int updateByPrimaryKey(County record);
    /**
     * 根据市的id查询所有的区县
     */
    List<County> getAllCounty(int city_id);
}