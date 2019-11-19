package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Skill implements Serializable {
    private Integer skillId;

    private String skillName;

    private static final long serialVersionUID = 1L;
}