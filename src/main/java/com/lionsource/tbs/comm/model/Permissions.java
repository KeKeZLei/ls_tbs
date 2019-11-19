package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Permissions implements Serializable {
    private Integer perId;

    private String perName;

    private static final long serialVersionUID = 1L;
}