package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Collection implements Serializable {
    private Integer collId;

    private Integer steId;

    private Integer memId;

    private Date collCreatetime;

    private static final long serialVersionUID = 1L;
}