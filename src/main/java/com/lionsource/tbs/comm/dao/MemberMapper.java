package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Member;
import com.lionsource.tbs.comm.model.Referrer;
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

    /**
     * 根据用户用户名和手机号码进行登录
     * @param member
     * @return
     */
    List<Member> getMemnameTel(Member member);

    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param member
     * @return
     */
    List<Member> getMemtel(Member member);

    /**
     * 根据电话号码查询用户姓名
     * @param member
     * @return
     */
    String getMemname(Member member);

    /**
     * 判断手机号码是否存在
     * @param mem_tel
     * @return
     */
    List<Member> getAllMemnameTel(String mem_tel);
}