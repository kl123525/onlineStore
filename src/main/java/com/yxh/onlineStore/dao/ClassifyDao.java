package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Classify;

public interface ClassifyDao {
    int deleteByPrimaryKey(String categoryId);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String categoryId);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}