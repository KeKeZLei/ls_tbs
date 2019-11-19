package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Province;
import java.util.List;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer provId);

    int insert(Province record);

    Province selectByPrimaryKey(Integer provId);

    List<Province> selectAll();

    int updateByPrimaryKey(Province record);
}