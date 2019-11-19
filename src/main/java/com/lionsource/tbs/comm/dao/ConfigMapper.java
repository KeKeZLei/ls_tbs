package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Config;
import java.util.List;

public interface ConfigMapper {
    int deleteByPrimaryKey(Integer conId);

    int insert(Config record);

    Config selectByPrimaryKey(Integer conId);

    List<Config> selectAll();

    int updateByPrimaryKey(Config record);

    //获取所有短信配置
    List<Config> selectMsg();
}