package com.lionsource.tbs.proscenum.serverD.service.impl;

import com.lionsource.tbs.comm.dao.TagMapper;
import com.lionsource.tbs.proscenum.serverD.service.TagServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagServiceImpl implements TagServiceI {
    @Autowired
    private TagMapper tagMapper;
    /**
     * 根据技能id查询技能名称 yc
     * @param tag_id
     * @return
     */
    @Override
    public String selectTagName(Integer tag_id){
        return tagMapper.selectTagName(tag_id);
    }
}
