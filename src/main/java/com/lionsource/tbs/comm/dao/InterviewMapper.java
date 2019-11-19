package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Interview;
import java.util.List;

public interface InterviewMapper {
    int deleteByPrimaryKey(Integer interId);

    int insert(Interview record);

    Interview selectByPrimaryKey(Integer interId);

    List<Interview> selectAll();

    int updateByPrimaryKey(Interview record);
}