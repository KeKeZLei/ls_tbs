package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.RolePg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePgMapper {
    int deleteByPrimaryKey(Integer rpgId);

    int insert(RolePg record);

    RolePg selectByPrimaryKey(Integer rpgId);

    List<RolePg> selectAll();

    int updateByPrimaryKey(RolePg record);

    //批量插入角色权限组关系
    int batchInsert(@Param("list") List<RolePg> rolePgList);

    //根据角色编号删除角色权限组
    int deleteByRoleId(Integer roleId);
}