package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Notice;
import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer notId);

    int insert(Notice record);

    Notice selectByPrimaryKey(Integer notId);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice record);
}