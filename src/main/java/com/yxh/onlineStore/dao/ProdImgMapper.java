package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.ProdImg;

public interface ProdImgMapper {
    int deleteByPrimaryKey(String prodImgId);

    int insert(ProdImg record);

    int insertSelective(ProdImg record);

    ProdImg selectByPrimaryKey(String prodImgId);

    int updateByPrimaryKeySelective(ProdImg record);

    int updateByPrimaryKey(ProdImg record);
}