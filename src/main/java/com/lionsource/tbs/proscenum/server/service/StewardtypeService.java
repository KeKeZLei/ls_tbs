package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Stewardtype;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 3:57
 * @Version 1.0
 * 管家类型接口
 */
public interface StewardtypeService {
    /**
     * 查询所有的管家类型
     * @return
     */
    List<Stewardtype> selectAll();
    //根据工作编号查询工作名称
    String selectWardType(int steWardTypeId);
}
