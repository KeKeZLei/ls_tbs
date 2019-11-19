package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Steward implements Serializable {
    private Integer steId;

    private Integer refId;

    private String steOpenid;

    private String steWhead;

    private String steChead;

    private String steName;

    private String steTel;

    private String steIdcardnum;

    private String steIdcardfront;

    private String steIdcardreverse;

    private String steIdcardreason;

    private Integer steSex;

    private Integer steAge;

    private String steNative;

    private String steAddress;

    private String steWorkstate;

    private String steRealnamestate;

    private Integer steContracttype;

    private Integer steWorkyear;

    private Integer steExpsalary;

    private String steWorkform;

    private String steCerstate;

    private Date steCreatetime;

    private Integer steState;

    private Integer steProvince;

    private Integer steCity;

    private String steNickname;

    private String steWorktype;

    private String steSkill;

    private String steTag;

    private String steDescribe;

    private static final long serialVersionUID = 1L;
}