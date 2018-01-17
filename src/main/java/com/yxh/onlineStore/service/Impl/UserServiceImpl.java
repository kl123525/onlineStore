package com.yxh.onlineStore.service.Impl;

import com.yxh.onlineStore.dao.UserDao;
import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 杨旭晖 on 2018/1/14.
 */
@Service
public class UserServiceImpl implements UserService{
    private CommonUtils utils = new CommonUtils();
    @Autowired
    UserDao userDao;

    public void insertUser(User user) {
        String prefix = user.getPrefix();
        String timestamp = utils.getTimestamp();
        String threadId = utils.getThreadId();
        String randomNum = utils.get3RandomNum();
        String uId = prefix + timestamp + threadId + randomNum;
        Timestamp regDate = utils.getMysqlDate();
        user.setuId(uId);
        user.setRegDate(regDate);
        user.setLevel(0);
        user.setExp(0);
        user.setAddrNum(0);
        userDao.insert(user);
    }


}
