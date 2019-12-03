package com.lionsource.tbs.proscenum.server.service;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/2 0002 上午 11:21
 * @Version 1.0
 * 雇佣关系
 */
public interface EmprelationService {
    /**
     * 根据管家编号查询雇佣关系的用户编号
     * @param steId
     * @return
     */
    int selectByEmpId(int steId);
}
