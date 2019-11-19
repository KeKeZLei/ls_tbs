package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Province implements Serializable {
    private Integer provId;

    private String provName;

    private static final long serialVersionUID = 1L;
}