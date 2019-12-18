package com.lionsource.tbs.proscenum.serverY.service;

import com.lionsource.tbs.comm.model.Notice;

import java.util.List;

public interface NoticeServicel {

    int insert(Notice record);

    List<Notice> selectmemId(Integer memId);
}
