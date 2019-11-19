package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.PerPg;

import java.util.List;

public interface PerPgMapper {
    int deleteByPrimaryKey(Integer ppId);

    int insert(PerPg record);

    PerPg selectByPrimaryKey(Integer ppId);

    List<PerPg> selectAll();

    int updateByPrimaryKey(PerPg record);
}