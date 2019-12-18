package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer evaId);

    int insert(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaId);

    List<Evaluate> selectAll();

    int updateByPrimaryKey(Evaluate record);

    /**
     * 根据管家编号查询用户评价信息
     * @param steid
     * @return
     */
    Evaluate getBySteid(int steid);

    /**
     * 根据管家编号查询所有评价
     * @param steid
     * @return
     */
    List<Evaluate> selectEvaluate(@Param("set_id") Integer steid);

}