package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Helpinfo implements Serializable {
    private Integer hiId;

    private String hiType;

    private String hiQuestion;

    private String hiAnswer;

    private static final long serialVersionUID = 1L;
}