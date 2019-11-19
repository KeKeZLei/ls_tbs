package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Emprelation implements Serializable {
    private Integer emprelId;

    private Integer memId;

    private Integer steId;

    private String emprelState;

    private Date emprelStarttime;

    private Date emprelEndtime;

    private static final long serialVersionUID = 1L;
}