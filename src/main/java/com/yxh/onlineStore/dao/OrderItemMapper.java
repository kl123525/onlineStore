package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(String orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(String orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}