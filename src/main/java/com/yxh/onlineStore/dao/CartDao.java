package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Cart;

public interface CartDao {
    int deleteByPrimaryKey(String cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(String cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}