package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    //根据角色名查询角色
    Role selectByName(String roleName);

    //获取最大角色编号
    Integer selectMaxId();
}