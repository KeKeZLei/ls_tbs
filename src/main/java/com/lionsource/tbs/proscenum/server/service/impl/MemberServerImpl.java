package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.MemberMapper;
import com.lionsource.tbs.comm.model.Member;
import com.lionsource.tbs.proscenum.server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/28 0028 下午 3:26
 * @Version 1.0
 */
@Service
public class MemberServerImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    /**
     * 根据用户用户名和手机号码进行登录
     * @param member
     * @return
     */
    public List<Member> getMemnameTel(Member member){
        return memberMapper.getMemnameTel(member);
    }

    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param member
     * @return
     */
    public List<Member> getMemtel(Member member){
        return memberMapper.getMemtel(member);
    }

    /**
     * 根据电话号码查询用户姓名
     * @param member
     * @return
     */
    public String getMemname(Member member){
        return memberMapper.getMemname(member);
    }
}
