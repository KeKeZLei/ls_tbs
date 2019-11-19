package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Evaluate implements Serializable {
    private Integer evaId;

    private Integer memId;

    private Integer steId;

    private Integer evaService;

    private Integer evaSkill;

    private Integer evaProquality;

    private String evaComment;

    private Integer evaAgreestate;

    private Integer evaState;

    private Date evaCreatetime;

    private Date evaTime;

    private Integer evaEvastate;

    private static final long serialVersionUID = 1L;
}