package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class City implements Serializable {
    private Integer cityId;

    private Integer proId;

    private String cityName;

    private static final long serialVersionUID = 1L;
}