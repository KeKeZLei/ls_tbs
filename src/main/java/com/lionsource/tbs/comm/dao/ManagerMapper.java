package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer manaId);

    int insert(Manager record);

    Manager selectByPrimaryKey(Integer manaId);

    List<Manager> selectAll();

    int updateByPrimaryKey(Manager record);

    //根据参数查询所有管理员
    List<Manager> selectAllByParam(Map<String, Object> param);

    //修改管理员状态
    int updateState(Manager manager);

    //根据登录名查询管理员
    Manager selectByLoginname(String manaLoginname);

    //根据手机号查询管理员
    Manager selectByTel(String manaTel);

    //根据角色编号查询管理员
    List<Manager> selectByRoleId(Integer roleId);

    //根据用户名密码查询管理员
    Manager selectByParam(@Param("userName") String userName, @Param("password") String password);

    //修改密码
    int updatePwd(@Param("manaId") Integer manaId, @Param("pwd") String pwd);
}