package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Product;

public interface ProductDao {
    int deleteByPrimaryKey(String prodId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String prodId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}