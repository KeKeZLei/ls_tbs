package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Member implements Serializable {
    private Integer memId;

    private Integer refId;

    private String memOpenid;

    private String memHead;

    private String memName;

    private String memTel;

    private String memIdcardnum;

    private String memIdcardfront;

    private String memIdcardreverse;

    private String memIdcardreason;

    private Integer memSex;

    private String memCall;

    private String memRealnamestate;

    private Integer memVipstate;

    private Date memVipterm;

    private String memEmployment;

    private String memWorkform;

    private Integer memContracttype;

    private Integer memWorkyear;

    private String memAgerange;

    private String memNativedemand;

    private String memWorktime;

    private Integer memServicetime;

    private Integer memExpectpay;

    private String memOtherdemand;

    private Date memCreatetime;

    private Integer memState;

    private String memNickname;

    private String memStewardtype;

    private String memSkilldemand;

    private static final long serialVersionUID = 1L;
}