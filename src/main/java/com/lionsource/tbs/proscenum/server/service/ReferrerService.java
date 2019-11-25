package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Referrer;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 上午 10:55
 * @Version 1.0
 * 推荐人接口
 */
public interface ReferrerService {
    /**
     * 根据推荐人姓名查询推荐人
     * @param ref_name
     * @return
     */
    public List<Referrer> getRef_name(String ref_name);

    /**
     * 根据姓名查询推荐人ID
     * @param ref_name
     * @return
     */
    int selectByref_id(String ref_name);
}
