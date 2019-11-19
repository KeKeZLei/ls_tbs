package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Referrer implements Serializable {
    private Integer refId;

    private String refOpenid;

    private String refHead;

    private String refName;

    private String refTel;

    private String refIdcardnum;

    private String refIdcardfront;

    private String refIdcardreverse;

    private String refIdcardreason;

    private String refBanknum;

    private String refBankdeposit;

    private String refBankfront;

    private String refBankaudit;

    private String refBankreason;

    private Integer refProvince;

    private Integer refCity;

    private Integer refCounty;

    private String refAddress;

    private String refRealnamestate;

    private Date refCreatetime;

    private Date refCoopterm;

    private Integer refState;

    private String refNickname;

    private static final long serialVersionUID = 1L;
}