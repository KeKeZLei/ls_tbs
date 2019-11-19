package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Orders;
import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer ordId);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer ordId);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
}