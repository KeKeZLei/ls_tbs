package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class News implements Serializable {
    private Integer newsId;

    private String newsTitle;

    private String newsSubtitle;

    private String newsThumb;

    private String newsCover;

    private Integer newsState;

    private Date newsCreatetime;

    private String newsContent;

    private static final long serialVersionUID = 1L;

    //处理后的缩略图
    private String tagThumb;
    //处理后的封图
    private String tagCover;
}