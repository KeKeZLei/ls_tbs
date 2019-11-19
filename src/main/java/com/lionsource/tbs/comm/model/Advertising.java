package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Advertising implements Serializable {
    private Integer advId;

    private String advLocal;

    private String advTitel;

    private String advPicture;

    private String advUrl;

    private Integer advSort;

    private static final long serialVersionUID = 1L;
}