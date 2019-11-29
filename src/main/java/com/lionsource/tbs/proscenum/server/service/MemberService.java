package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.dao.MemberMapper;
import com.lionsource.tbs.comm.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/28 0028 下午 3:24
 * @Version 1.0
 * 用户接口
 */
public interface MemberService {
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
}
