package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.CountyMapper;
import com.lionsource.tbs.comm.model.County;
import com.lionsource.tbs.proscenum.server.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/2 0002 上午 9:06
 * @Version 1.0
 */
@Service
public class CountyServiceImpl implements CountyService {
    @Autowired
    CountyMapper countyMapper;
    /**
     * 根据市的id查询所有的区县
     */
    public List<County> getAllCounty(int city_id){
        return countyMapper.getAllCounty(city_id);
    }
}
