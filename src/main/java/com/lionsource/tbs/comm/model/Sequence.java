package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Sequence implements Serializable {
    private String name;

    private Integer currentValue;

    private Integer increment;

    private static final long serialVersionUID = 1L;
}