package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Pergroup implements Serializable {
    private Integer pergId;

    private String pergName;

    private Integer pergParentid;

    private String pergUrl;

    private String pergIcon;

    private String pergPage;

    private static final long serialVersionUID = 1L;
}