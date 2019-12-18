package com.lionsource.tbs.proscenum.serverY.service;

import com.lionsource.tbs.comm.model.Memaddress;

import java.util.List;

public interface MemaddressMapperYI {
    /**
     * 显示所有地址
     * @return
     */
    List<Memaddress> selectAll();

    /**
     * 根据id删除地址
     * @param manaId
     * @return
     */
    int deleteByPrimaryKey(Integer manaId);

    /**
     * 添加地址
     * @param record
     * @return
     */
    int insert(Memaddress record);

    /**
     * 修改地址
     * @param record
     * @return
     */
    int updateByPrimaryKey(Memaddress record);

    /**
     * 根据id查询对象
     * @param maId
     * @return
     */
    Memaddress selectByPrimaryKey(Integer maId);
}
