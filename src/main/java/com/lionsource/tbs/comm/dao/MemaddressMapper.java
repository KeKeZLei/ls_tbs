package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Memaddress;
import java.util.List;

public interface MemaddressMapper {
    int deleteByPrimaryKey(Integer maId);

    int insert(Memaddress record);

    Memaddress selectByPrimaryKey(Integer maId);

    List<Memaddress> selectAll();

    int updateByPrimaryKey(Memaddress record);
}