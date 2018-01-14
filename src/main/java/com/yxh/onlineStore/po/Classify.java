package com.yxh.onlineStore.po;

public class Classify {
    private String categoryId;

    private String name;

    private String fid;

    private Byte index;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public Byte getIndex() {
        return index;
    }

    public void setIndex(Byte index) {
        this.index = index;
    }
}