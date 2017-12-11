package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(String addrId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String addrId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}