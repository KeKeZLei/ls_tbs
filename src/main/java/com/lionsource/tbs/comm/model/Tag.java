package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Tag implements Serializable {
    private Integer tagId;

    private String tagName;

    private static final long serialVersionUID = 1L;
}