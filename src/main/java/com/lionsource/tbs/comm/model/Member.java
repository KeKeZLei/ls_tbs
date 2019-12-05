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

    public Member() {
    }

    public Member(Integer memId, Integer refId, String memOpenid, String memHead, String memName, String memTel, String memIdcardnum, String memIdcardfront, String memIdcardreverse, String memIdcardreason, Integer memSex, String memCall, String memRealnamestate, Integer memVipstate, Date memVipterm, String memEmployment, String memWorkform, Integer memContracttype, Integer memWorkyear, String memAgerange, String memNativedemand, String memWorktime, Integer memServicetime, Integer memExpectpay, String memOtherdemand, Date memCreatetime, Integer memState, String memNickname, String memStewardtype, String memSkilldemand) {
        this.memId = memId;
        this.refId = refId;
        this.memOpenid = memOpenid;
        this.memHead = memHead;
        this.memName = memName;
        this.memTel = memTel;
        this.memIdcardnum = memIdcardnum;
        this.memIdcardfront = memIdcardfront;
        this.memIdcardreverse = memIdcardreverse;
        this.memIdcardreason = memIdcardreason;
        this.memSex = memSex;
        this.memCall = memCall;
        this.memRealnamestate = memRealnamestate;
        this.memVipstate = memVipstate;
        this.memVipterm = memVipterm;
        this.memEmployment = memEmployment;
        this.memWorkform = memWorkform;
        this.memContracttype = memContracttype;
        this.memWorkyear = memWorkyear;
        this.memAgerange = memAgerange;
        this.memNativedemand = memNativedemand;
        this.memWorktime = memWorktime;
        this.memServicetime = memServicetime;
        this.memExpectpay = memExpectpay;
        this.memOtherdemand = memOtherdemand;
        this.memCreatetime = memCreatetime;
        this.memState = memState;
        this.memNickname = memNickname;
        this.memStewardtype = memStewardtype;
        this.memSkilldemand = memSkilldemand;
    }

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

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public String getMemOpenid() {
        return memOpenid;
    }

    public void setMemOpenid(String memOpenid) {
        this.memOpenid = memOpenid;
    }

    public String getMemHead() {
        return memHead;
    }

    public void setMemHead(String memHead) {
        this.memHead = memHead;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemTel() {
        return memTel;
    }

    public void setMemTel(String memTel) {
        this.memTel = memTel;
    }

    public String getMemIdcardnum() {
        return memIdcardnum;
    }

    public void setMemIdcardnum(String memIdcardnum) {
        this.memIdcardnum = memIdcardnum;
    }

    public String getMemIdcardfront() {
        return memIdcardfront;
    }

    public void setMemIdcardfront(String memIdcardfront) {
        this.memIdcardfront = memIdcardfront;
    }

    public String getMemIdcardreverse() {
        return memIdcardreverse;
    }

    public void setMemIdcardreverse(String memIdcardreverse) {
        this.memIdcardreverse = memIdcardreverse;
    }

    public String getMemIdcardreason() {
        return memIdcardreason;
    }

    public void setMemIdcardreason(String memIdcardreason) {
        this.memIdcardreason = memIdcardreason;
    }

    public Integer getMemSex() {
        return memSex;
    }

    public void setMemSex(Integer memSex) {
        this.memSex = memSex;
    }

    public String getMemCall() {
        return memCall;
    }

    public void setMemCall(String memCall) {
        this.memCall = memCall;
    }

    public String getMemRealnamestate() {
        return memRealnamestate;
    }

    public void setMemRealnamestate(String memRealnamestate) {
        this.memRealnamestate = memRealnamestate;
    }

    public Integer getMemVipstate() {
        return memVipstate;
    }

    public void setMemVipstate(Integer memVipstate) {
        this.memVipstate = memVipstate;
    }

    public Date getMemVipterm() {
        return memVipterm;
    }

    public void setMemVipterm(Date memVipterm) {
        this.memVipterm = memVipterm;
    }

    public String getMemEmployment() {
        return memEmployment;
    }

    public void setMemEmployment(String memEmployment) {
        this.memEmployment = memEmployment;
    }

    public String getMemWorkform() {
        return memWorkform;
    }

    public void setMemWorkform(String memWorkform) {
        this.memWorkform = memWorkform;
    }

    public Integer getMemContracttype() {
        return memContracttype;
    }

    public void setMemContracttype(Integer memContracttype) {
        this.memContracttype = memContracttype;
    }

    public Integer getMemWorkyear() {
        return memWorkyear;
    }

    public void setMemWorkyear(Integer memWorkyear) {
        this.memWorkyear = memWorkyear;
    }

    public String getMemAgerange() {
        return memAgerange;
    }

    public void setMemAgerange(String memAgerange) {
        this.memAgerange = memAgerange;
    }

    public String getMemNativedemand() {
        return memNativedemand;
    }

    public void setMemNativedemand(String memNativedemand) {
        this.memNativedemand = memNativedemand;
    }

    public String getMemWorktime() {
        return memWorktime;
    }

    public void setMemWorktime(String memWorktime) {
        this.memWorktime = memWorktime;
    }

    public Integer getMemServicetime() {
        return memServicetime;
    }

    public void setMemServicetime(Integer memServicetime) {
        this.memServicetime = memServicetime;
    }

    public Integer getMemExpectpay() {
        return memExpectpay;
    }

    public void setMemExpectpay(Integer memExpectpay) {
        this.memExpectpay = memExpectpay;
    }

    public String getMemOtherdemand() {
        return memOtherdemand;
    }

    public void setMemOtherdemand(String memOtherdemand) {
        this.memOtherdemand = memOtherdemand;
    }

    public Date getMemCreatetime() {
        return memCreatetime;
    }

    public void setMemCreatetime(Date memCreatetime) {
        this.memCreatetime = memCreatetime;
    }

    public Integer getMemState() {
        return memState;
    }

    public void setMemState(Integer memState) {
        this.memState = memState;
    }

    public String getMemNickname() {
        return memNickname;
    }

    public void setMemNickname(String memNickname) {
        this.memNickname = memNickname;
    }

    public String getMemStewardtype() {
        return memStewardtype;
    }

    public void setMemStewardtype(String memStewardtype) {
        this.memStewardtype = memStewardtype;
    }

    public String getMemSkilldemand() {
        return memSkilldemand;
    }

    public void setMemSkilldemand(String memSkilldemand) {
        this.memSkilldemand = memSkilldemand;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private String memNickname;

    private String memStewardtype;

    private String memSkilldemand;

    private static final long serialVersionUID = 1L;
}