package com.yxh.onlineStore.utils;

import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.Impl.UserServiceImpl;
import com.yxh.onlineStore.service.UserService;

/**
 * Created by 杨旭晖 on 2018/1/17.
 */
public class test {

    public static void main(String[] args) {
        CommonUtils commonUtils = new CommonUtils();
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setAccount("13477098324");
        user.setAddrNum(0);
        user.setExp(0);
        user.setImg("0");
        user.setAddrId("0");
        user.setTrueName("yyxh");
        user.setSex("n");
        user.setPassword("123456");
        user.setNickName("11122");
        user.setPoint(0);
        user.setRegDate(commonUtils.getMysqlDate());
        user.setuId("0000000000000000000000000");
        user.setLv(0);
        userService.insertUser(user);
    }
}
