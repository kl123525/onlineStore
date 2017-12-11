package com.yxh.onlineStore.po;

import java.math.BigDecimal;

public class CartItem {
    private String cartItemId;

    private String cartId;

    private String prodId;

    private BigDecimal price;

    private Byte quantity;

    private Byte buy;

    private String name;

    private String storeId;

    private String prodImgId;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId == null ? null : cartItemId.trim();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId == null ? null : cartId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public Byte getBuy() {
        return buy;
    }

    public void setBuy(Byte buy) {
        this.buy = buy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getProdImgId() {
        return prodImgId;
    }

    public void setProdImgId(String prodImgId) {
        this.prodImgId = prodImgId == null ? null : prodImgId.trim();
    }
}