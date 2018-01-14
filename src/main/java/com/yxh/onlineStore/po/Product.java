package com.yxh.onlineStore.po;

import java.math.BigDecimal;

public class Product {
    private String prodId;

    private String prodName;

    private String storeId;

    private Integer stock;

    private BigDecimal price;

    private String categoryId;

    private Byte skuNum;

    private Byte exp;

    private Byte point;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public Byte getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Byte skuNum) {
        this.skuNum = skuNum;
    }

    public Byte getExp() {
        return exp;
    }

    public void setExp(Byte exp) {
        this.exp = exp;
    }

    public Byte getPoint() {
        return point;
    }

    public void setPoint(Byte point) {
        this.point = point;
    }
}