package com.yxh.onlineStore.po;

import java.util.Date;

public class Seller {
    private String sellerId;

    private String trueName;

    private String nickName;

    private String account;

    private Date regDate;

    private Byte storeNum;

    private String img;

    private Integer point;

    private Byte description;

    private Byte service;

    private Byte logistics;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Byte getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Byte storeNum) {
        this.storeNum = storeNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Byte getDescription() {
        return description;
    }

    public void setDescription(Byte description) {
        this.description = description;
    }

    public Byte getService() {
        return service;
    }

    public void setService(Byte service) {
        this.service = service;
    }

    public Byte getLogistics() {
        return logistics;
    }

    public void setLogistics(Byte logistics) {
        this.logistics = logistics;
    }
}