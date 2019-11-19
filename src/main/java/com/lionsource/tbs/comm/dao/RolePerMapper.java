package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.RolePer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePerMapper {
    int deleteByPrimaryKey(Integer rpId);

    int insert(RolePer record);

    RolePer selectByPrimaryKey(Integer rpId);

    List<RolePer> selectAll();

    int updateByPrimaryKey(RolePer record);

    //批量插入角色权限关系
    int batchInsert(@Param("list") List<RolePer> rolePerList);

    //根据角色编号删除角色权限
    int deleteByRoleId(Integer roleId);
}