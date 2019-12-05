package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.StewardtypeMapper;
import com.lionsource.tbs.comm.model.Stewardtype;
import com.lionsource.tbs.proscenum.server.service.StewardtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 3:57
 * @Version 1.0
 * 实现管家接口
 */
@Service
public class StewardtypeServiceImpl implements StewardtypeService {
    @Autowired
    private StewardtypeMapper stewardtypeMapper;
    /**
     * 查询所有的管家类型
     * @return
     */
    /**
     * 查询所有的管家类型
     * @return
     */
    public List<Stewardtype> selectAll(){
        return stewardtypeMapper.selectAll();
    }

    //根据工作编号查询工作名称
    public String selectWardType(int steWardTypeId){
        return stewardtypeMapper.selectWardType(steWardTypeId);
    }
}

