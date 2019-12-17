package com.lionsource.tbs.proscenum.serverY.service.impl;

import com.lionsource.tbs.comm.dao.CertificateMapper;
import com.lionsource.tbs.comm.model.Certificate;
import com.lionsource.tbs.proscenum.serverY.service.CertificateServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServicelmpl implements CertificateServicel {
    @Autowired
    private CertificateMapper mapper;

    @Override
    public List<Certificate> selectsteid(Integer steId) {
        return mapper.selectsteid(steId);
    }
}
