package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.EmprelationMapper;
import com.lionsource.tbs.proscenum.server.service.EmprelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/2 0002 上午 11:22
 * @Version 1.0
 * 雇佣关系
 */
@Service
public class EmprelationServiceImpl implements EmprelationService {
    @Autowired
    private EmprelationMapper emprelationMapper;
    /**
     * 根据管家编号查询雇佣关系的用户信息
     * @param steId
     * @return
     */
    public int selectByEmpId(int steId){
        return emprelationMapper.selectByEmpId(steId);
    }
}
