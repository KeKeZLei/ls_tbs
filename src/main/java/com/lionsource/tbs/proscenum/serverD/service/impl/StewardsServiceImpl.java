package com.lionsource.tbs.proscenum.serverD.service.impl;

import com.lionsource.tbs.comm.dao.StewardMapper;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.serverD.service.StewardServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StewardsServiceImpl implements StewardServiceI {
    @Autowired
    private StewardMapper stewardMapper;
    @Override
    public int StewardAdd(Steward steward) {
        return stewardMapper.insert(steward);
    }
}
