package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Emprelation;
import java.util.List;
import java.util.Map;

public interface EmprelationMapper {
    int deleteByPrimaryKey(Integer emprelId);

    int insert(Emprelation record);

    Emprelation selectByPrimaryKey(Integer emprelId);

    List<Emprelation> selectAll();

    int updateByPrimaryKey(Emprelation record);

    //通过会员编号查询相关管家信息
    List<Map<String,Object>>selectBySteId(Integer memId);
}