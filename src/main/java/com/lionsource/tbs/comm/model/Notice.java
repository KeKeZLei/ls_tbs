package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Notice implements Serializable {
    private Integer notId;

    private String notType;

    private String notTitle;

    private Date notCreatetime;

    private Integer refId;

    private Integer memId;

    private Integer steId;

    private String notContent;

    private static final long serialVersionUID = 1L;
}
