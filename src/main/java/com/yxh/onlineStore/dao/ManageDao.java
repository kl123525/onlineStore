package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Manage;

public interface ManageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}