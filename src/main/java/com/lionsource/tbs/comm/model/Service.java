package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Service implements Serializable {
    private Integer serId;

    private String serName;

    private String serHead;

    private String serTel;

    private String serQrcode;

    private static final long serialVersionUID = 1L;
}