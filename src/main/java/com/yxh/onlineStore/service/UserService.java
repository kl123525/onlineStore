package com.yxh.onlineStore.service;

        import com.yxh.onlineStore.po.User;

/**
 * Created by 杨旭晖 on 2018/1/14.
 */
public interface UserService {

    int insertUser(User user);

    boolean sendPhoneCode(String mobileNum);

}
