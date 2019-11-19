package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Skill;
import java.util.List;

public interface SkillMapper {
    int deleteByPrimaryKey(Integer skillId);

    int insert(Skill record);

    Skill selectByPrimaryKey(Integer skillId);

    List<Skill> selectAll();

    int updateByPrimaryKey(Skill record);

    //根据技能名称查询技能
    Skill selectBySkillName(String skillName);
}