package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Service;
import java.util.List;

public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serId);

    int insert(Service record);

    Service selectByPrimaryKey(Integer serId);

    List<Service> selectAll();

    int updateByPrimaryKey(Service record);
}