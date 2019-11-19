package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Advertising;
import java.util.List;

public interface AdvertisingMapper {

    int deleteByPrimaryKey(Integer advId);

    int insert(Advertising record);

    Advertising selectByPrimaryKey(Integer advId);

    List<Advertising> selectAll();

    int updateByPrimaryKey(Advertising record);
}