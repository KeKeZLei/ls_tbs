package com.lionsource.tbs.proscenum.serverY.service.impl;

import com.lionsource.tbs.comm.dao.NoticeMapper;
import com.lionsource.tbs.comm.model.Notice;
import com.lionsource.tbs.proscenum.serverY.service.NoticeServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServicelmpl implements NoticeServicel {
    @Autowired
    private NoticeMapper mapper;
    @Override
    public int insert(Notice record) {
        return mapper.insert(record);
    }

    @Override
    public List<Notice> selectmemId(Integer memId) {
        return mapper.selectmemId(memId);
    }
}
