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

    public Steward(Integer steId, Integer refId, String steOpenid, String steWhead, String steChead, String steName, String steTel, String steIdcardnum, String steIdcardfront, String steIdcardreverse, String steIdcardreason, Integer steSex, Integer steAge, String steNative, String steAddress, String steWorkstate, String steRealnamestate, Integer steContracttype, Integer steWorkyear, Integer steExpsalary, String steWorkform, String steCerstate, Date steCreatetime, Integer steState, Integer steProvince, Integer steCity, String steNickname, String steWorktype, String steSkill, String steTag, String steDescribe) {
        this.steId = steId;
        this.refId = refId;
        this.steOpenid = steOpenid;
        this.steWhead = steWhead;
        this.steChead = steChead;
        this.steName = steName;
        this.steTel = steTel;
        this.steIdcardnum = steIdcardnum;
        this.steIdcardfront = steIdcardfront;
        this.steIdcardreverse = steIdcardreverse;
        this.steIdcardreason = steIdcardreason;
        this.steSex = steSex;
        this.steAge = steAge;
        this.steNative = steNative;
        this.steAddress = steAddress;
        this.steWorkstate = steWorkstate;
        this.steRealnamestate = steRealnamestate;
        this.steContracttype = steContracttype;
        this.steWorkyear = steWorkyear;
        this.steExpsalary = steExpsalary;
        this.steWorkform = steWorkform;
        this.steCerstate = steCerstate;
        this.steCreatetime = steCreatetime;
        this.steState = steState;
        this.steProvince = steProvince;
        this.steCity = steCity;
        this.steNickname = steNickname;
        this.steWorktype = steWorktype;
        this.steSkill = steSkill;
        this.steTag = steTag;
        this.steDescribe = steDescribe;
    }
}