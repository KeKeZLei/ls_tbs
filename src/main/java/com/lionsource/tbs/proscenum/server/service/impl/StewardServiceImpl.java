package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.StewardMapper;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.server.service.StewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 下午 4:11
 * @Version 1.0
 */
@Service
public class StewardServiceImpl implements StewardService {
    @Autowired
    private StewardMapper stewardMapper;
    /**
     * 从业者申请
     * @param steward
     * @return
     */
    public int serverAddApply(Steward steward){
        return stewardMapper.serverAddApply(steward);
    }
}
