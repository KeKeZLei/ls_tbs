package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Referrer;
import java.util.List;

public interface ReferrerMapper {
    int deleteByPrimaryKey(Integer refId);

    int insert(Referrer record);

    Referrer selectByPrimaryKey(Integer refId);

    List<Referrer> selectAll();

    int updateByPrimaryKey(Referrer record);

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