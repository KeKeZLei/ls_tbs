package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Config implements Serializable {
    private Integer conId;

    private String conName;

    private String conCode;

    private String conValue;

    private static final long serialVersionUID = 1L;
}