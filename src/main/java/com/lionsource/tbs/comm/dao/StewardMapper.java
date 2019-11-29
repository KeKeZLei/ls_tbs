package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Steward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StewardMapper {
    int deleteByPrimaryKey(Integer steId);

    int insert(Steward record);

    Steward selectByPrimaryKey(Integer steId);

    List<Steward> selectAll();

    int updateByPrimaryKey(Steward record);

    //根据管家类型编号查询管家
    List<Steward> selectAllByStId(@Param("stId") String stId);

    //根据技能编号查询管家
    List<Steward> selectAllBySkillId(@Param("skillId") String skillId);

    //根据标签编号查询管家
    List<Steward> selectAllByTagId(@Param("tagId") String tagId);

    /**
     * 量身定制管家
     *多条件查询：
     * 职业类别 ste_worktype
     * 是否住家 ste_workform
     *
     */
    List<Steward> selectAllfbxp(@Param("ste_worktype") String ste_worktype,@Param("ste_workform") String ste_workform,@Param("ste_contracttype")String ste_contracttype,@Param("ste_workyear")int ste_workyear,@Param("ste_expsalary") int ste_expsalary,@Param("ste_native") String ste_native);

    /**
     * 从业者申请
     * @param steward
     * @return
     */
    int serverAddApply(Steward steward);
}