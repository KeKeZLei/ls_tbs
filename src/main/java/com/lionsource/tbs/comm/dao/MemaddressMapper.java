package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Memaddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemaddressMapper {
    int deleteByPrimaryKey(@Param("ma_id") Integer maId,@Param("mem_id") Integer meId);

    int insert(Memaddress record);

    Memaddress selectByPrimaryKey(Integer maId);

    List<Memaddress> selectAll();

    int updateByPrimaryKey(Memaddress record);

    List<Memaddress> selectmemId(@Param("mem_id") Integer memId);

    List<Memaddress> selectmaIsdefault(@Param("mem_id")Integer memId);

    List<Memaddress> selectmaIsdefaultmaid(@Param("ma_id")Integer maId);
}