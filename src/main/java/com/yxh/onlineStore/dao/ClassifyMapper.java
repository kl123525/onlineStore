package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Classify;

public interface ClassifyMapper {
    int deleteByPrimaryKey(String classifyId);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String classifyId);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}