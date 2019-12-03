package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Tag;
import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);

    //根据标签名称查询标签
    Tag selectByTagName(String tagName);
    //根据标签编号查询名称
    String selectByTagId(int tagid);
}