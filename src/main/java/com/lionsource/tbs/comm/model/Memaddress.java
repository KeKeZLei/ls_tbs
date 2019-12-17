package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Memaddress implements Serializable {
    private Integer maId;

    private Integer memId;

    private Integer maProvince;

    private Integer maCity;

    private Integer maCounty;

    private String maAddress;

    private String maContact;

    private String maTel;

    private Integer maIsdefault;

    public Integer getMaId() {
        return maId;
    }

    public void setMaId(Integer maId) {
        this.maId = maId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getMaProvince() {
        return maProvince;
    }

    public void setMaProvince(Integer maProvince) {
        this.maProvince = maProvince;
    }

    public Integer getMaCity() {
        return maCity;
    }

    public void setMaCity(Integer maCity) {
        this.maCity = maCity;
    }

    public Integer getMaCounty() {
        return maCounty;
    }

    public void setMaCounty(Integer maCounty) {
        this.maCounty = maCounty;
    }

    public String getMaAddress() {
        return maAddress;
    }

    public void setMaAddress(String maAddress) {
        this.maAddress = maAddress;
    }

    public String getMaContact() {
        return maContact;
    }

    public void setMaContact(String maContact) {
        this.maContact = maContact;
    }

    public String getMaTel() {
        return maTel;
    }

    public void setMaTel(String maTel) {
        this.maTel = maTel;
    }

    public Integer getMaIsdefault() {
        return maIsdefault;
    }

    public void setMaIsdefault(Integer maIsdefault) {
        this.maIsdefault = maIsdefault;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;
}