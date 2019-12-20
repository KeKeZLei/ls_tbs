package com.lionsource.tbs.proscenum.serverD.service.impl;

import com.lionsource.tbs.comm.dao.EvaluateMapper;
import com.lionsource.tbs.comm.model.Evaluate;
import com.lionsource.tbs.comm.model.Member;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.serverD.service.EvaluateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpls implements EvaluateServices {
    @Autowired
    private EvaluateMapper evaluateMapper;
    /**
     * 根据评价用户编号查询用户信息 yc
     * @param memid
     * @return
     */
    @Override
    public List<Evaluate> getByMemid(int memid) {
        List<Evaluate> list =evaluateMapper.getByMemid(memid);
        return list;
    }

    /**
     * 根据评价管家编号查询管家信息 yc
     * @param steids
     * @return
     */
    @Override
    public List<Steward> getBySteids(int steids) {
        List<Steward> stewardList=null;
        List<Evaluate> list = evaluateMapper.getBySteids(steids);
        for (Evaluate  ls:list
             ) {
            stewardList=ls.getSteward();
        }
        return stewardList;
    }

    /**
     * 评价管家 yc
     * @param evaluate
     * @return
     */
    @Override
    public int getEvaluateAdd(Evaluate evaluate) {
        int count =evaluateMapper.getEvaluateAdd(evaluate);
        if (count>0){
            System.err.println("添加成功...");
        }else {
            System.out.println("添加失败...");
        }
        return count;
    }
}
