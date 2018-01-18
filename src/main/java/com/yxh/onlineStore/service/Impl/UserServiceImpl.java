package com.yxh.onlineStore.service.Impl;

import com.yxh.onlineStore.dao.UserDao;
import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.CommonUtils;
import com.yxh.onlineStore.utils.DaYuService;
import com.yxh.onlineStore.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;


/**
 * Created by 杨旭晖 on 2018/1/14.
 */
@Service
public class UserServiceImpl implements UserService{
    private DaYuService daYuService = new DaYuService();
    private CommonUtils utils = new CommonUtils();
    private RedisUtil redisUtil = new RedisUtil();
    @Autowired
    private UserDao userDao;

    public int insertUser(User user) {
        String prefix = user.getPrefix();
        String timestamp = utils.getTimestamp();
        String threadId = utils.getThreadId();
        String randomNum = utils.get3RandomNum();
        String uId = prefix + timestamp + threadId + randomNum;
        Timestamp regDate = utils.getMysqlDate();
        user.setuId(uId);
        user.setRegDate(regDate);
        user.setLv(0);
        user.setExp(0);
        user.setAddrNum(0);
        user.setPoint(0);
        return userDao.insert(user);
    }

    public boolean sendPhoneCode(String mobileNum) {
        //如果mysql没有此手机号则发送验证码
        if (userDao.hasMobileNum(mobileNum)==null){
            Map<Boolean,String> map;
            //发送验证码
            map = daYuService.sendPhoneCode(mobileNum);
            if(map.containsKey(true)) {
                //如果redis还存在此手机号的验证码则删除
                if (redisUtil.hasKey(mobileNum)) {
                    redisUtil.del(mobileNum);
                }
                redisUtil.set(mobileNum,map.get(true),180);
            }
            return true;
        }else
            return false;
    }


}
