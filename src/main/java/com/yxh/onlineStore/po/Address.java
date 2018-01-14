package com.yxh.onlineStore.po;

import java.util.Date;

public class Address {
    private String addrId;

    private String postCode;

    private String name;

    private String phoneNo;

    private String area1;

    private String area2;

    private String area3;

    private String area4;

    private String address;

    private Byte isDefault;

    private Date createDate;

    private String uId;

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId == null ? null : addrId.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1 == null ? null : area1.trim();
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2 == null ? null : area2.trim();
    }

    public String getArea3() {
        return area3;
    }

    public void setArea3(String area3) {
        this.area3 = area3 == null ? null : area3.trim();
    }

    public String getArea4() {
        return area4;
    }

    public void setArea4(String area4) {
        this.area4 = area4 == null ? null : area4.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }
}