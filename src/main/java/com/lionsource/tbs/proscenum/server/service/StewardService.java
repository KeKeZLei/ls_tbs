package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Steward;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 下午 4:10
 * @Version 1.0
 * 管家服务人员接口
 */
public interface StewardService {
    /**
     * 从业者申请
     * @param steward
     * @return
     */
    int serverAddApply(Steward steward);

    /**
     * 查询从业者手机号码是否存在
     */
    public int selectPhone(String steTel);

    /**
     * 根据用户名和手机号码进行登录
     * @param steward
     * @return
     */
    List<Steward> getStenameStetel(Steward steward);
    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param steward
     * @return
     */
    List<Steward> getStetel(Steward steward);

    /**
     * 根据电话号码查询服务人员姓名
     * @param steward
     * @return
     */
    String getStetelSteName(Steward steward);
    /**
     *根据服务人员姓名查询个人信息
     * @param steName
     * @return
     */
    Steward getSelectAllSteName(String steName);

    /**
     * 根据用户查询管家的编号
     * @param steName
     * @return
     */
    int getSelectOneSteId(String steName);
}
