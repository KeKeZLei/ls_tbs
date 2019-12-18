package com.lionsource.tbs.proscenum.serverY.service.impl;

import com.lionsource.tbs.comm.dao.EvaluateMapper;
import com.lionsource.tbs.comm.model.Evaluate;
import com.lionsource.tbs.proscenum.serverY.service.EvaluateServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServicelmpl implements EvaluateServicel {
    @Autowired
    private EvaluateMapper mapper;

    @Override
    public List<Evaluate> selectEvaluate(Integer steid) {
        return mapper.selectEvaluate(steid);
    }
}
