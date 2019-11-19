package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Pergroup;

import java.util.List;

public interface PergroupMapper {
    int deleteByPrimaryKey(Integer pergId);

    int insert(Pergroup record);

    Pergroup selectByPrimaryKey(Integer pergId);

    List<Pergroup> selectAll();

    int updateByPrimaryKey(Pergroup record);

    //根据角色编号查询权限组
    List<Pergroup> selectByRoleId(Integer roleId);
}