package com.lionsource.tbs.comm.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Data
public class Manager implements Serializable {
    private Integer manaId;

    public Integer getManaId() {
        return manaId;
    }

    public void setManaId(Integer manaId) {
        this.manaId = manaId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getManaName() {
        return manaName;
    }

    public void setManaName(String manaName) {
        this.manaName = manaName;
    }

    public String getManaTel() {
        return manaTel;
    }

    public void setManaTel(String manaTel) {
        this.manaTel = manaTel;
    }

    public String getManaLoginname() {
        return manaLoginname;
    }

    public void setManaLoginname(String manaLoginname) {
        this.manaLoginname = manaLoginname;
    }

    public String getManaPassword() {
        return manaPassword;
    }

    public void setManaPassword(String manaPassword) {
        this.manaPassword = manaPassword;
    }

    public String getManaHeadpath() {
        return manaHeadpath;
    }

    public void setManaHeadpath(String manaHeadpath) {
        this.manaHeadpath = manaHeadpath;
    }

    public Date getManaCreatetime() {
        return manaCreatetime;
    }

    public void setManaCreatetime(Date manaCreatetime) {
        this.manaCreatetime = manaCreatetime;
    }

    public Integer getManaState() {
        return manaState;
    }

    public void setManaState(Integer manaState) {
        this.manaState = manaState;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    private Integer roleId;

    private String manaName;

    private String manaTel;

    private String manaLoginname;

    private String manaPassword;

    private String manaHeadpath;

    private Date manaCreatetime;

    private Integer manaState;

    private static final long serialVersionUID = 1L;

    //角色名称
    private String roleName;
    //旧密码
    private String oldPwd;
}