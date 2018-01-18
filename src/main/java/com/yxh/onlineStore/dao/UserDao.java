package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(String uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    String hasMobileNum(String account);

    User selectByAccount(String account);
}