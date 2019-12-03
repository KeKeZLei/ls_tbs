package com.lionsource.tbs.proscenum.serverY.service;

import com.lionsource.tbs.comm.model.Steward;

import java.util.List;

public interface StewardyServiceI {

    /**
     * 定制管家
     * @return
     */
    List<Steward> selectAllfbxp(String ste_worktype,String ste_workform,String ste_contracttype,int ste_workyear,int ste_expsalary,String ste_native,String ste_tag);
}
