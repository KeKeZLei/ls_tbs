package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.SkillMapper;
import com.lionsource.tbs.comm.model.Skill;
import com.lionsource.tbs.proscenum.server.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 下午 3:41
 * @Version 1.0
 */
@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillMapper skillMapper;
    /**
     * 查询所有的个人技能
     * @return
     */
    public List<Skill> selectAll(){
        return skillMapper.selectAll();
    }
}
