package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.CartItem;

public interface CartItemMapper {
    int deleteByPrimaryKey(String cartItemId);

    int insert(CartItem record);

    int insertSelective(CartItem record);

    CartItem selectByPrimaryKey(String cartItemId);

    int updateByPrimaryKeySelective(CartItem record);

    int updateByPrimaryKey(CartItem record);
}