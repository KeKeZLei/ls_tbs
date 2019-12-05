package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Referrer;
import com.lionsource.tbs.comm.model.Steward;

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
     * 根据推荐人的编号查询推荐人姓名
     * @param ref_id
     * @return
     */
    public String getRef_Id(int ref_id);

    /**
     * 根据姓名查询推荐人ID
     * @param ref_name
     * @return
     */
    int selectByref_id(String ref_name);

    /**
     * 根据推荐人用户名和手机号码进行登录
     * @param referrer
     * @return
     */
    List<Referrer> getRefnameReftel(Referrer referrer);

    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param referrer
     * @return
     */
    List<Referrer> getReftel(Referrer referrer);

    /**
     * 根据电话号码查询推荐人姓名
     * @param referrer
     * @return
     */
    String getReferrerRefname(Referrer referrer);
    /**
     * 根据ref_tel查询相关用户信息
     * @param ref_tel
     * @return
     * yc
     */
    List<Referrer> getReferrers(String ref_tel);

    /**
     * 根据ref_id查询推荐管家人数
     * @param ref_id
     * @return
     * yc
     */
    int getMemberCount(Integer ref_id);
    /**
     * 根据ref_id查询推荐实名管家人数
     * @param ref_id
     * @return
     * yc
     */
    int getMemberCountsm(Integer ref_id);

    /**
     *根据ref_id查询推荐用户人数
     * @param ref_id
     * @return
     * yc
     */
    int getStewardCount(Integer ref_id);
    /**
     *根据ref_id查询推荐实名用户人数
     * @param ref_id
     * @return
     * yc
     */
    int getStewardCountsm(Integer ref_id);
}