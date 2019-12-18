package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Evaluate implements Serializable {
    private Integer evaId;

    private Integer memId;

    private Integer steId;

    private Integer evaService;

    private Integer evaSkill;

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

    private Integer evaProquality;

    private String evaComment;

    private Integer evaAgreestate;

    private Integer evaState;

    private Date evaCreatetime;

    private Date evaTime;

    private Integer evaEvastate;

    private static final long serialVersionUID = 1L;
}