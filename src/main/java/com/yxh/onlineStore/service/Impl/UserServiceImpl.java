package com.yxh.onlineStore.service.Impl;

import com.yxh.onlineStore.dao.UserDao;
import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 杨旭晖 on 2018/1/14.
 */
@Service
public class UserServiceImpl implements UserService{
    private CommonUtils utils = new CommonUtils();
    @Autowired
    UserDao userDao;
    public void insertUser(User user) {
        String prefix = "001";
        String timestamp = utils.getTimestamp();
        String threadId = utils.getThreadId();
        String ranomNum = utils.get3RandomNum();
        String uId = prefix + timestamp + threadId + ranomNum;
        user.setuId(uId);
        userDao.insert(user);

    }

}
