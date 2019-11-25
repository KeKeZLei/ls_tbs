package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.ProvinceMapper;
import com.lionsource.tbs.comm.model.Province;
import com.lionsource.tbs.proscenum.server.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 9:44
 * @Version 1.0
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    /**
     * 查看所有的省份
     * @return
     */
   public List<Province> selectAll(){
        return provinceMapper.selectAll();
    }

}
