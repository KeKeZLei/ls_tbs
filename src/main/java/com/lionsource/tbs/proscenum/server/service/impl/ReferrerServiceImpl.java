package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.ReferrerMapper;
import com.lionsource.tbs.comm.model.Referrer;
import com.lionsource.tbs.proscenum.server.service.ReferrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 上午 10:56
 * @Version 1.0
 */
@Service
public class ReferrerServiceImpl implements ReferrerService {
    @Autowired
    private ReferrerMapper referrerMapper;
    /**
     * 根据推荐人姓名查询推荐人
     * @param ref_name
     * @return
     */
    public List<Referrer> getRef_name(String ref_name){
        return referrerMapper.getRef_name(ref_name);
    }
    /**
     * 根据姓名查询推荐人ID
     * @param ref_name
     * @return
     */
    public int selectByref_id(String ref_name){
        return referrerMapper.selectByref_id(ref_name);
    }

    /**
     * 根据推荐人用户名和手机号码进行登录
     * @param referrer
     * @return
     */
   public List<Referrer> getRefnameReftel(Referrer referrer){
        return referrerMapper.getReftel(referrer);
    }

    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param referrer
     * @return
     */
    public List<Referrer> getReftel(Referrer referrer){
        return referrerMapper.getReftel(referrer);
    }

    /**
     * 根据电话号码查询推荐人姓名
     * @param referrer
     * @return
     */
    public String getReferrerRefname(Referrer referrer){
        return referrerMapper.getReferrerRefname(referrer);
    }
}
