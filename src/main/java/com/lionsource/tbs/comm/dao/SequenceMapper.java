package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Sequence;
import java.util.List;

public interface SequenceMapper {
    int deleteByPrimaryKey(String name);

    int insert(Sequence record);

    Sequence selectByPrimaryKey(String name);

    List<Sequence> selectAll();

    int updateByPrimaryKey(Sequence record);
}