package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Certificate;
import java.util.List;

public interface CertificateMapper {
    int deleteByPrimaryKey(Integer cerId);

    int insert(Certificate record);

    Certificate selectByPrimaryKey(Integer cerId);

    List<Certificate> selectAll();

    int updateByPrimaryKey(Certificate record);
}