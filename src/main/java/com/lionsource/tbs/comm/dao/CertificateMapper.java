package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Certificate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CertificateMapper {
    int deleteByPrimaryKey(Integer cerId);

    int insert(Certificate record);

    Certificate selectByPrimaryKey(Integer cerId);

    List<Certificate> selectAll();

    int updateByPrimaryKey(Certificate record);

    /**
     * 根据管加信息查询管家证书
     * @param steId
     * @return
     */
    List<Certificate> selectsteid(@Param("ste_id") Integer steId);


}