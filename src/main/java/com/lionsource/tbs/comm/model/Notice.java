package com.lionsource.tbs.comm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@ToString
@Data
public class Notice implements Serializable {
    private Integer notId;

    private String notType;

    private String notTitle;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date notCreatetime;

    private Integer refId;

    private Integer memId;

    private Integer steId;

    private String notContent;

    private static final long serialVersionUID = 1L;

    public Integer getNotId() {
        return notId;
    }

    public void setNotId(Integer notId) {
        this.notId = notId;
    }

    public String getNotType() {
        return notType;
    }

    public void setNotType(String notType) {
        this.notType = notType;
    }

    public String getNotTitle() {
        return notTitle;
    }

    public void setNotTitle(String notTitle) {
        this.notTitle = notTitle;
    }

    public Date getNotCreatetime() {
        return notCreatetime;
    }

    public void setNotCreatetime(Date notCreatetime) {
        this.notCreatetime = notCreatetime;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
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

    public String getNotContent() {
        return notContent;
    }

    public void setNotContent(String notContent) {
        this.notContent = notContent;
    }
}
