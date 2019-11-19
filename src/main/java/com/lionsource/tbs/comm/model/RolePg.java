package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class RolePg implements Serializable {
    private Integer rpgId;

    private Integer roleId;

    private Integer pergId;

    private static final long serialVersionUID = 1L;
}