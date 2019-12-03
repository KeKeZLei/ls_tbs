package com.lionsource.tbs.proscenum.serverY.service.impl;


import com.lionsource.tbs.comm.dao.StewardMapper;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.serverY.service.StewardyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StewardServiceImply implements StewardyServiceI {

    @Autowired
    private StewardMapper stewardMapper;

    @Override
    public List<Steward> selectAllfbxp(String ste_worktype,String ste_workform,String ste_contracttype,int ste_workyear,int ste_expsalary,String ste_native,String ste_tag) {
        return stewardMapper.selectAllfbxp(ste_worktype,ste_workform,ste_contracttype,ste_workyear,ste_expsalary,ste_native,ste_tag);
    }
}
