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

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public String getRefOpenid() {
        return refOpenid;
    }

    public void setRefOpenid(String refOpenid) {
        this.refOpenid = refOpenid;
    }

    public String getRefHead() {
        return refHead;
    }

    public void setRefHead(String refHead) {
        this.refHead = refHead;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getRefTel() {
        return refTel;
    }

    public void setRefTel(String refTel) {
        this.refTel = refTel;
    }

    public String getRefIdcardnum() {
        return refIdcardnum;
    }

    public void setRefIdcardnum(String refIdcardnum) {
        this.refIdcardnum = refIdcardnum;
    }

    public String getRefIdcardfront() {
        return refIdcardfront;
    }

    public void setRefIdcardfront(String refIdcardfront) {
        this.refIdcardfront = refIdcardfront;
    }

    public String getRefIdcardreverse() {
        return refIdcardreverse;
    }

    public void setRefIdcardreverse(String refIdcardreverse) {
        this.refIdcardreverse = refIdcardreverse;
    }

    public String getRefIdcardreason() {
        return refIdcardreason;
    }

    public void setRefIdcardreason(String refIdcardreason) {
        this.refIdcardreason = refIdcardreason;
    }

    public String getRefBanknum() {
        return refBanknum;
    }

    public void setRefBanknum(String refBanknum) {
        this.refBanknum = refBanknum;
    }

    public String getRefBankdeposit() {
        return refBankdeposit;
    }

    public void setRefBankdeposit(String refBankdeposit) {
        this.refBankdeposit = refBankdeposit;
    }

    public String getRefBankfront() {
        return refBankfront;
    }

    public void setRefBankfront(String refBankfront) {
        this.refBankfront = refBankfront;
    }

    public String getRefBankaudit() {
        return refBankaudit;
    }

    public void setRefBankaudit(String refBankaudit) {
        this.refBankaudit = refBankaudit;
    }

    public String getRefBankreason() {
        return refBankreason;
    }

    public void setRefBankreason(String refBankreason) {
        this.refBankreason = refBankreason;
    }

    public Integer getRefProvince() {
        return refProvince;
    }

    public void setRefProvince(Integer refProvince) {
        this.refProvince = refProvince;
    }

    public Integer getRefCity() {
        return refCity;
    }

    public void setRefCity(Integer refCity) {
        this.refCity = refCity;
    }

    public Integer getRefCounty() {
        return refCounty;
    }

    public void setRefCounty(Integer refCounty) {
        this.refCounty = refCounty;
    }

    public String getRefAddress() {
        return refAddress;
    }

    public void setRefAddress(String refAddress) {
        this.refAddress = refAddress;
    }

    public String getRefRealnamestate() {
        return refRealnamestate;
    }

    public void setRefRealnamestate(String refRealnamestate) {
        this.refRealnamestate = refRealnamestate;
    }

    public Date getRefCreatetime() {
        return refCreatetime;
    }

    public void setRefCreatetime(Date refCreatetime) {
        this.refCreatetime = refCreatetime;
    }

    public Date getRefCoopterm() {
        return refCoopterm;
    }

    public void setRefCoopterm(Date refCoopterm) {
        this.refCoopterm = refCoopterm;
    }

    public Integer getRefState() {
        return refState;
    }

    public void setRefState(Integer refState) {
        this.refState = refState;
    }

    public String getRefNickname() {
        return refNickname;
    }

    public void setRefNickname(String refNickname) {
        this.refNickname = refNickname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private Integer refCity;

    private Integer refCounty;

    private String refAddress;

    private String refRealnamestate;

    @Override
    public String toString() {
        return "Referrer{" +
                "refId=" + refId +
                ", refOpenid='" + refOpenid + '\'' +
                ", refHead='" + refHead + '\'' +
                ", refName='" + refName + '\'' +
                ", refTel='" + refTel + '\'' +
                ", refIdcardnum='" + refIdcardnum + '\'' +
                ", refIdcardfront='" + refIdcardfront + '\'' +
                ", refIdcardreverse='" + refIdcardreverse + '\'' +
                ", refIdcardreason='" + refIdcardreason + '\'' +
                ", refBanknum='" + refBanknum + '\'' +
                ", refBankdeposit='" + refBankdeposit + '\'' +
                ", refBankfront='" + refBankfront + '\'' +
                ", refBankaudit='" + refBankaudit + '\'' +
                ", refBankreason='" + refBankreason + '\'' +
                ", refProvince=" + refProvince +
                ", refCity=" + refCity +
                ", refCounty=" + refCounty +
                ", refAddress='" + refAddress + '\'' +
                ", refRealnamestate='" + refRealnamestate + '\'' +
                ", refCreatetime=" + refCreatetime +
                ", refCoopterm=" + refCoopterm +
                ", refState=" + refState +
                ", refNickname='" + refNickname + '\'' +
                '}';
    }

    private Date refCreatetime;

    private Date refCoopterm;

    private Integer refState;

    private String refNickname;

    private static final long serialVersionUID = 1L;
}