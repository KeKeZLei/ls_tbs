package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class PerPg implements Serializable {
    private Integer ppId;

    private Integer pergId;

    private Integer perId;

    private static final long serialVersionUID = 1L;
}