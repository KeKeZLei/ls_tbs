package com.lionsource.tbs.comm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@ToString
@Data
public class Interview implements Serializable {
    private Integer interId;

    private Integer memId;

    private String interService;

    private String interAddress;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date interTime;

    private String interState;

    private String interSteward;

    private static final long serialVersionUID = 1L;
}