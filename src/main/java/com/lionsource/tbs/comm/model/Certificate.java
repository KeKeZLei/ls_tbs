package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Certificate implements Serializable {
    private Integer cerId;

    private Integer steId;

    private String cerName;

    private String cerImg;

    private String cerAuditstate;

    private String cerDisreason;

    private static final long serialVersionUID = 1L;
}