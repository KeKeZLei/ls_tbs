package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer perId);

    int insert(Permissions record);

    Permissions selectByPrimaryKey(Integer perId);

    List<Permissions> selectAll();

    int updateByPrimaryKey(Permissions record);

    //根据角色编号查询权限
    List<Permissions> selectByRoleId(Integer roleId);

    //根据权限组编号和角色编号查询权限
    List<Map<String, Object>> selectByParam(@Param("pergId") Integer pergId, @Param("mroleId") Integer mroleId);
}