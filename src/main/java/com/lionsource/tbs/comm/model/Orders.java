package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Orders implements Serializable {
    private Integer ordId;

    private Integer memId;

    private String ordBillno;

    private String ordName;

    private Double ordPrice;

    private String ordPaystate;

    private String ordPaytype;

    private Date ordPaytime;

    private static final long serialVersionUID = 1L;
}