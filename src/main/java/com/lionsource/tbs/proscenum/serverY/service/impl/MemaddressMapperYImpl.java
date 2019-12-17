package com.lionsource.tbs.proscenum.serverY.service.impl;

import com.lionsource.tbs.comm.dao.MemaddressMapper;
import com.lionsource.tbs.comm.model.Memaddress;
import com.lionsource.tbs.proscenum.serverY.service.MemaddressMapperYI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemaddressMapperYImpl implements MemaddressMapperYI {
    @Autowired
    private MemaddressMapper mapper;

    @Override
    public List<Memaddress> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer manaId) {
        return mapper.deleteByPrimaryKey(manaId);
    }

    @Override
    public int insert(Memaddress record) {
        return mapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Memaddress record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Memaddress selectByPrimaryKey(Integer maId) {
        return mapper.selectByPrimaryKey(maId);
    }
}
