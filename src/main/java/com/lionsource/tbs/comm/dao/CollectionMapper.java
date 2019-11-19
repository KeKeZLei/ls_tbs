package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Collection;
import java.util.List;

public interface CollectionMapper {

    int deleteByPrimaryKey(Integer collId);

    int insert(Collection record);

    Collection selectByPrimaryKey(Integer collId);

    List<Collection> selectAll();

    int updateByPrimaryKey(Collection record);
}