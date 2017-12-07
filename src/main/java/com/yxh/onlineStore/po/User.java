package com.yxh.onlineStore.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private static final long serialVersionUID = 8465535886492239611L;

    private String uId;

    private String uAccount;

    private String uPwd;

    private Date uRegDate;

    private String uSex;

    private String uNickName;

    private String uTrueName;

    private Byte uLevel;

    private Integer uScore;

    private String uAddrId;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public Date getuRegDate() {
        return uRegDate;
    }

    public void setuRegDate(Date uRegDate) {
        this.uRegDate = uRegDate;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public String getuNickName() {
        return uNickName;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName == null ? null : uNickName.trim();
    }

    public String getuTrueName() {
        return uTrueName;
    }

    public void setuTrueName(String uTrueName) {
        this.uTrueName = uTrueName == null ? null : uTrueName.trim();
    }

    public Byte getuLevel() {
        return uLevel;
    }

    public void setuLevel(Byte uLevel) {
        this.uLevel = uLevel;
    }

    public Integer getuScore() {
        return uScore;
    }

    public void setuScore(Integer uScore) {
        this.uScore = uScore;
    }

    public String getuAddrId() {
        return uAddrId;
    }

    public void setuAddrId(String uAddrId) {
        this.uAddrId = uAddrId == null ? null : uAddrId.trim();
    }
}