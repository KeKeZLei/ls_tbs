package com.lionsource.tbs.proscenum.serverY.service.impl;


import com.lionsource.tbs.comm.dao.MemberMapper;
import com.lionsource.tbs.comm.model.Member;
import com.lionsource.tbs.proscenum.serverY.service.MemberyServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberyServerImpl  implements MemberyServerI {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public List<Member> getAllMemnameTel(String mem_tel) {
        return memberMapper.getAllMemnameTel(mem_tel);
    }

    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }
}
