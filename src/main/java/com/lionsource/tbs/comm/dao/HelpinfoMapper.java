package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Helpinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HelpinfoMapper {
    int deleteByPrimaryKey(Integer hiId);

    int insert(Helpinfo record);

    Helpinfo selectByPrimaryKey(Integer hiId);

    List<Helpinfo> selectAll();

    int updateByPrimaryKey(Helpinfo record);

    //根据问题查询帮助信息
    Helpinfo selectByQuestion(@Param("question") String question, @Param("type") String type);

    //批量删除帮助信息
    int batchDelete(String hiIds);
}