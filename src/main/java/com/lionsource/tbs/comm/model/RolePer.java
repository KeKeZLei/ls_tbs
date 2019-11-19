package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class RolePer implements Serializable {
    private Integer rpId;

    private Integer roleId;

    private Integer perId;

    private static final long serialVersionUID = 1L;
}