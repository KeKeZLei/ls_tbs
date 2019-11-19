package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class County implements Serializable {
    private Integer counId;

    private Integer cityId;

    private String counName;

    private static final long serialVersionUID = 1L;
}