package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Stewardtype implements Serializable {
    private Integer stId;

    private String stIcon;

    @Override
    public String toString() {
        return "Stewardtype{" +
                "stId=" + stId +
                ", stIcon='" + stIcon + '\'' +
                ", stName='" + stName + '\'' +
                ", stState=" + stState +
                ", stCreatetime=" + stCreatetime +
                '}';
    }

    private String stName;

    private Integer stState;

    private Date stCreatetime;

    private static final long serialVersionUID = 1L;
}