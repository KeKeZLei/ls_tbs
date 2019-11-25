package com.lionsource.tbs.proscenum.server.service;

import com.lionsource.tbs.comm.model.Province;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 9:41
 * @Version 1.0
 * 省份接口
 */
public interface ProvinceService {
    /**
     * 查看所有的省份
     * @return
     */
    List<Province> selectAll();
}
