package com.lionsource.tbs.proscenum.serverY.service;

import com.lionsource.tbs.comm.model.Member;

import java.util.List;

public interface MemberyServerI {

    List<Member> getAllMemnameTel(String mem_tel);

    int insert(Member member);
}
