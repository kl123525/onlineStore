package com.yxh.onlineStore.po;

public class ProdImg {
    private String prodImgId;

    private String img;

    private Byte type;

    private Byte index;

    private String prodId;

    public String getProdImgId() {
        return prodImgId;
    }

    public void setProdImgId(String prodImgId) {
        this.prodImgId = prodImgId == null ? null : prodImgId.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getIndex() {
        return index;
    }

    public void setIndex(Byte index) {
        this.index = index;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }
}