package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.CityMapper;
import com.lionsource.tbs.comm.model.City;
import com.lionsource.tbs.proscenum.server.service.CitySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.CharacterIterator;
import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 9:49
 * @Version 1.0
 */
@Service
public class CitySerivceImpl implements CitySerivce {
    @Autowired
    private CityMapper cityMapper;
    /**
     * 根据省份的id查询所有的城市
     */
    public List<City> getAllCity(int provId){
        return cityMapper.getAllCity(provId);
    }
}
