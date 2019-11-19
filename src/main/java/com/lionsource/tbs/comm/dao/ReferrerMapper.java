package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Referrer;
import java.util.List;

public interface ReferrerMapper {
    int deleteByPrimaryKey(Integer refId);

    int insert(Referrer record);

    Referrer selectByPrimaryKey(Integer refId);

    List<Referrer> selectAll();

    int updateByPrimaryKey(Referrer record);
}