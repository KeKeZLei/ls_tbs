package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Steward;

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
}
