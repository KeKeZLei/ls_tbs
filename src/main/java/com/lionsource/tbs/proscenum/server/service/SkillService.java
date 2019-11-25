package com.lionsource.tbs.proscenum.server.service;


import com.lionsource.tbs.comm.model.Skill;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 下午 3:40
 * @Version 1.0
 * 个人技能接口
 */
public interface SkillService {
    /**
     * 查询所有的个人技能
     * @return
     */
    List<Skill> selectAll();
}
