package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Store;

public interface StoreDao {
    int deleteByPrimaryKey(String storeId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(String storeId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}