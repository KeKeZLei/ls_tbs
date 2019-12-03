package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.TagMapper;
import com.lionsource.tbs.comm.model.Tag;
import com.lionsource.tbs.proscenum.server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 4:44
 * @Version 1.0
 * 个人标签
 */
@Service
public class TagServiceimpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    /**
     * 查询所有的个人标签
     * @return
     */
    public List<Tag> selectAll(){
        return tagMapper.selectAll();
    }
    //根据标签编号查询名称
    public  String selectByTagId(int tagid){
        return tagMapper.selectByTagId(tagid);
    }
}
