package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Evaluate;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/1 0001 下午 4:54
 * @Version 1.0
 * 评价管理
 */
public interface EvaluateService {
    /**
     * 根据管家编号查询用户评价信息
     * @param steid
     * @return
     */
    Evaluate getBySteid(int steid);
}
