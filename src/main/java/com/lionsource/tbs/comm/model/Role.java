package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Role implements Serializable {
    private Integer roleId;

    private String roleName;

    private String roleDescribe;

    private static final long serialVersionUID = 1L;

    //权限组编号集合(多个以分号分割)
    private String pgIds;
    //权限编号集合(多个以分号分割)
    private String perIds;
}