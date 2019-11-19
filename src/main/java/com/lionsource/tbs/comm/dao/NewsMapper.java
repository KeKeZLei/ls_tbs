package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.News;
import java.util.List;
import java.util.Map;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    News selectByPrimaryKey(Integer newsId);

    List<News> selectAll();

    int updateByPrimaryKey(News record);

    //根据参数查询所有新闻
    List<News> selectAllByParam(Map<String, Object> param);

    //修改新闻状态
    int updateState(News news);

    //根据标题查询新闻
    News selectByTitle(String newsTitle);

    //批量删除新闻
    int batchDelete(String newsIds);
}