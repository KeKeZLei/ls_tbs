package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Interview implements Serializable {
    private Integer interId;

    private Integer memId;

    private String interService;

    private String interAddress;

    private Date interTime;

    private String interState;

    private String interSteward;

    private static final long serialVersionUID = 1L;
}