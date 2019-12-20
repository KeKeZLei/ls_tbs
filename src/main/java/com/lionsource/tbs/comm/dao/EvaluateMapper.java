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
     * 根据评价用户编号查询用户信息 yc
     * @param memid
     * @return
     */
    List<Evaluate> getByMemid(int memid);

    /**
     * 根据评价管家编号查询管家信息 yc
     * @param steids
     * @return
     */
    List<Evaluate> getBySteids(int steids);
    /**
     * 评价管家 yc
     * @param evaluate
     * @return
     */
    int getEvaluateAdd(Evaluate evaluate);

}