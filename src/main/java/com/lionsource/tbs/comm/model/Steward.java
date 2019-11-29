package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Steward implements Serializable {
    public Steward() {
    }

    private Integer steId;

    private Integer refId;

    private String steOpenid;

    private String steWhead;

    private String steChead;

    private String steName;

    private String steTel;

    public Integer getSteId() {
        return steId;
    }

    public void setSteId(Integer steId) {
        this.steId = steId;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public String getSteOpenid() {
        return steOpenid;
    }

    public void setSteOpenid(String steOpenid) {
        this.steOpenid = steOpenid;
    }

    public String getSteWhead() {
        return steWhead;
    }

    public void setSteWhead(String steWhead) {
        this.steWhead = steWhead;
    }

    public String getSteChead() {
        return steChead;
    }

    public void setSteChead(String steChead) {
        this.steChead = steChead;
    }

    public String getSteName() {
        return steName;
    }

    public void setSteName(String steName) {
        this.steName = steName;
    }

    public String getSteTel() {
        return steTel;
    }

    public void setSteTel(String steTel) {
        this.steTel = steTel;
    }

    public String getSteIdcardnum() {
        return steIdcardnum;
    }

    public void setSteIdcardnum(String steIdcardnum) {
        this.steIdcardnum = steIdcardnum;
    }

    public String getSteIdcardfront() {
        return steIdcardfront;
    }

    public void setSteIdcardfront(String steIdcardfront) {
        this.steIdcardfront = steIdcardfront;
    }

    public String getSteIdcardreverse() {
        return steIdcardreverse;
    }

    public void setSteIdcardreverse(String steIdcardreverse) {
        this.steIdcardreverse = steIdcardreverse;
    }

    public String getSteIdcardreason() {
        return steIdcardreason;
    }

    public void setSteIdcardreason(String steIdcardreason) {
        this.steIdcardreason = steIdcardreason;
    }

    public Integer getSteSex() {
        return steSex;
    }

    public void setSteSex(Integer steSex) {
        this.steSex = steSex;
    }

    public Integer getSteAge() {
        return steAge;
    }

    public void setSteAge(Integer steAge) {
        this.steAge = steAge;
    }

    public String getSteNative() {
        return steNative;
    }

    public void setSteNative(String steNative) {
        this.steNative = steNative;
    }

    public String getSteAddress() {
        return steAddress;
    }

    public void setSteAddress(String steAddress) {
        this.steAddress = steAddress;
    }

    public String getSteWorkstate() {
        return steWorkstate;
    }

    public void setSteWorkstate(String steWorkstate) {
        this.steWorkstate = steWorkstate;
    }

    public String getSteRealnamestate() {
        return steRealnamestate;
    }

    public void setSteRealnamestate(String steRealnamestate) {
        this.steRealnamestate = steRealnamestate;
    }

    public Integer getSteContracttype() {
        return steContracttype;
    }

    public void setSteContracttype(Integer steContracttype) {
        this.steContracttype = steContracttype;
    }

    public Integer getSteWorkyear() {
        return steWorkyear;
    }

    public void setSteWorkyear(Integer steWorkyear) {
        this.steWorkyear = steWorkyear;
    }

    public Integer getSteExpsalary() {
        return steExpsalary;
    }

    public void setSteExpsalary(Integer steExpsalary) {
        this.steExpsalary = steExpsalary;
    }

    public String getSteWorkform() {
        return steWorkform;
    }

    public void setSteWorkform(String steWorkform) {
        this.steWorkform = steWorkform;
    }

    public String getSteCerstate() {
        return steCerstate;
    }

    public void setSteCerstate(String steCerstate) {
        this.steCerstate = steCerstate;
    }

    public Date getSteCreatetime() {
        return steCreatetime;
    }

    public void setSteCreatetime(Date steCreatetime) {
        this.steCreatetime = steCreatetime;
    }

    public Integer getSteState() {
        return steState;
    }

    public void setSteState(Integer steState) {
        this.steState = steState;
    }

    public Integer getSteProvince() {
        return steProvince;
    }

    public void setSteProvince(Integer steProvince) {
        this.steProvince = steProvince;
    }

    public Integer getSteCity() {
        return steCity;
    }

    public void setSteCity(Integer steCity) {
        this.steCity = steCity;
    }

    public String getSteNickname() {
        return steNickname;
    }

    public void setSteNickname(String steNickname) {
        this.steNickname = steNickname;
    }

    public String getSteWorktype() {
        return steWorktype;
    }

    public void setSteWorktype(String steWorktype) {
        this.steWorktype = steWorktype;
    }

    public String getSteSkill() {
        return steSkill;
    }

    public void setSteSkill(String steSkill) {
        this.steSkill = steSkill;
    }

    public String getSteTag() {
        return steTag;
    }

    public void setSteTag(String steTag) {
        this.steTag = steTag;
    }

    public String getSteDescribe() {
        return steDescribe;
    }

    public void setSteDescribe(String steDescribe) {
        this.steDescribe = steDescribe;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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