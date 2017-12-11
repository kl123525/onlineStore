package com.yxh.onlineStore.po;

import java.math.BigDecimal;

public class Product {
    private String prodId;

    private String prodName;

    private String storeId;

    private Integer stock;

    private BigDecimal price;

    private String classifyId;

    private Byte skuNum;

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

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public Byte getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Byte skuNum) {
        this.skuNum = skuNum;
    }
}