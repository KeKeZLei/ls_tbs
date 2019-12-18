package com.lionsource.tbs.proscenum.serverY.service;

import com.lionsource.tbs.comm.model.Steward;

import java.util.List;

public interface StewardyServiceI {

    /**
     * 定制管家
     * @return
     */
    List<Steward> selectAllfbxp(String ste_worktype,String ste_workform,String ste_contracttype,int ste_workyear,int ste_expsalary,String ste_native,String ste_tag);

    /**
     * 根据类型查询
     * @param ste_contracttype 签约形式
     * @param ste_worktype  职业类别
     * @return
     */
    List<Steward> selectAlllx(Integer ste_contracttype,String ste_worktype);

    /**
     * 根据经验查询
     * @param ste_workyear 工作经验
     * @return
     */
    List<Steward> selectAlljy( Integer ste_workyear);

    /**
     * 根据更多查询
     * @return
     */
    List<Steward> selectAllgd( String ste_workform, String ste_age, String ste_native, String ste_tag);

    //根据管家类型编号查询管家
    Steward selectByPrimaryKey(Integer steId);

    List<Steward> selectAll();

}
