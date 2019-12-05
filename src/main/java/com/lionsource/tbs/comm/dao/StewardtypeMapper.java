package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Stewardtype;
import java.util.List;

public interface StewardtypeMapper {
    int deleteByPrimaryKey(Integer stId);

    int insert(Stewardtype record);

    Stewardtype selectByPrimaryKey(Integer stId);

    List<Stewardtype> selectAll();

    int updateByPrimaryKey(Stewardtype record);

    //修改管家类型状态
    int updateState(Stewardtype stewardtype);

    //根据名称查询管家类型
    Stewardtype selectByStName(String stName);

    //根据工作编号查询工作名称
    String selectWardType(int steWardTypeId);
}