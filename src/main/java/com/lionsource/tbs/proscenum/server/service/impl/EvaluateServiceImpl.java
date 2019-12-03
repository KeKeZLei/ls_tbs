package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.EvaluateMapper;
import com.lionsource.tbs.comm.model.Evaluate;
import com.lionsource.tbs.proscenum.server.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/1 0001 下午 4:55
 * @Version 1.0
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    EvaluateMapper evaluateMapper;
    /**
     * 根据管家编号查询用户评价信息
     * @param steid
     * @return
     */
    public Evaluate getBySteid(int steid){
        return evaluateMapper.getBySteid(steid);
    }
}
