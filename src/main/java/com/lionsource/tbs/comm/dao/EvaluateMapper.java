package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Evaluate;
import java.util.List;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer evaId);

    int insert(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaId);

    List<Evaluate> selectAll();

    int updateByPrimaryKey(Evaluate record);
}