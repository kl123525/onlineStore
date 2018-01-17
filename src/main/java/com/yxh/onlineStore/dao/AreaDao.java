package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Area;

public interface AreaDao {
    int deleteByPrimaryKey(String areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}