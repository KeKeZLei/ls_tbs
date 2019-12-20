package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ToString
@Data
public class Evaluate implements Serializable {
    private List<Steward> steward;
    private List<Member> member;

    public List<Steward> getSteward() {
        return steward;
    }

    public void setSteward(List<Steward> steward) {
        this.steward = steward;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public Evaluate() {
    }

    public Evaluate(Integer evaId, Integer memId, Integer steId, Integer evaService, Integer evaSkill, Integer evaProquality, String evaComment, Integer evaAgreestate, Integer evaState, String evaCreatetimes, String evaTimes, Integer evaEvastate) {
        this.evaId = evaId;
        this.memId = memId;
        this.steId = steId;
        this.evaService = evaService;
        this.evaSkill = evaSkill;
        this.evaProquality = evaProquality;
        this.evaComment = evaComment;
        this.evaAgreestate = evaAgreestate;
        this.evaState = evaState;
        this.evaCreatetimes = evaCreatetimes;
        this.evaTimes = evaTimes;
        this.evaEvastate = evaEvastate;
    }

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

    private String evaCreatetimes;
    private String evaTimes;

    public String getEvaCreatetimes() {
        return evaCreatetimes;
    }

    public void setEvaCreatetimes(String evaCreatetimes) {
        this.evaCreatetimes = evaCreatetimes;
    }

    public String getEvaTimes() {
        return evaTimes;
    }

    public void setEvaTimes(String evaTimes) {
        this.evaTimes = evaTimes;
    }

    private static final long serialVersionUID = 1L;

    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getSteId() {
        return steId;
    }

    public void setSteId(Integer steId) {
        this.steId = steId;
    }

    public Integer getEvaService() {
        return evaService;
    }

    public void setEvaService(Integer evaService) {
        this.evaService = evaService;
    }

    public Integer getEvaSkill() {
        return evaSkill;
    }

    public void setEvaSkill(Integer evaSkill) {
        this.evaSkill = evaSkill;
    }

    public Integer getEvaProquality() {
        return evaProquality;
    }

    public void setEvaProquality(Integer evaProquality) {
        this.evaProquality = evaProquality;
    }

    public String getEvaComment() {
        return evaComment;
    }

    public void setEvaComment(String evaComment) {
        this.evaComment = evaComment;
    }

    public Integer getEvaAgreestate() {
        return evaAgreestate;
    }

    public void setEvaAgreestate(Integer evaAgreestate) {
        this.evaAgreestate = evaAgreestate;
    }

    public Integer getEvaState() {
        return evaState;
    }

    public void setEvaState(Integer evaState) {
        this.evaState = evaState;
    }

    public Date getEvaCreatetime() {
        return evaCreatetime;
    }

    public void setEvaCreatetime(Date evaCreatetime) {
        this.evaCreatetime = evaCreatetime;
    }

    public Date getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(Date evaTime) {
        this.evaTime = evaTime;
    }

    public Integer getEvaEvastate() {
        return evaEvastate;
    }

    public void setEvaEvastate(Integer evaEvastate) {
        this.evaEvastate = evaEvastate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
