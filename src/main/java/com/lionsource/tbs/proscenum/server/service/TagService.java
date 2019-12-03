package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Stewardtype;
import com.lionsource.tbs.comm.model.Tag;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 4:44
 * @Version 1.0
 * 个人标签接口
 */
public interface TagService {
    /**
     * 查询所有的个人标签
     * @return
     */
    List<Tag> selectAll();
    //根据标签编号查询名称
    String selectByTagId(int tagid);
}
