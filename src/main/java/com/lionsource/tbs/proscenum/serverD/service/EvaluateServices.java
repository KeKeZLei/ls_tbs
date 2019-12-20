package com.lionsource.tbs.proscenum.serverD.service;

import com.lionsource.tbs.comm.model.Evaluate;
import com.lionsource.tbs.comm.model.Member;
import com.lionsource.tbs.comm.model.Steward;

import java.util.List;

public interface EvaluateServices {
    /**
     * 根据评价用户编号查询用户信息 yc
     * @param memid
     * @return
     */
    List<Evaluate> getByMemid(int memid);

    /**
     * 根据评价管家编号查询管家信息 yc
     * @param steids
     * @return
     */
    List<Steward> getBySteids(int steids);

    /**
     * 评价管家 yc
     * @param evaluate
     * @return
     */
    int getEvaluateAdd(Evaluate evaluate);
}
