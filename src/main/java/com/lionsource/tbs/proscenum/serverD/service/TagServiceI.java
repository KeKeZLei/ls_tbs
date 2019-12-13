package com.lionsource.tbs.proscenum.serverD.service;

public interface TagServiceI {
    /**
     * 根据技能id查询技能名称 yc
     * @param tag_id
     * @return
     */
    String selectTagName(Integer tag_id);
}
