package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer memId);

    int insert(Member record);

    Member selectByPrimaryKey(Integer memId);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

    //根据管家类型编号查询会员
    List<Member> selectAllByStId(@Param("stId") String s);

    //根据技能编号查询会员
    List<Member> selectAllBySkillId(@Param("skillId") String skillId);
}