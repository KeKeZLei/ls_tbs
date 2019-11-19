package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Memaddress implements Serializable {
    private Integer maId;

    private Integer memId;

    private Integer maProvince;

    private Integer maCity;

    private Integer maCounty;

    private String maAddress;

    private String maContact;

    private String maTel;

    private Integer maIsdefault;

    private static final long serialVersionUID = 1L;
}