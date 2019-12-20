package com.lionsource.tbs.proscenum.serverY.service.impl;

import com.lionsource.tbs.comm.dao.InterviewMapper;
import com.lionsource.tbs.comm.model.Interview;
import com.lionsource.tbs.proscenum.serverY.service.InterviewServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewServicelmpl implements InterviewServicel {

    @Autowired
    private InterviewMapper mapper;

    @Override
    public List<Interview> selectmemId(Integer memId) {
        return mapper.selectmemId(memId);
    }
}
