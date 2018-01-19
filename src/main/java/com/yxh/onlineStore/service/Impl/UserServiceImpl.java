package com.yxh.onlineStore.service.Impl;

import com.yxh.onlineStore.dao.UserDao;
import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Map;


/**
 * Created by 杨旭晖 on 2018/1/14.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    DaYuService daYuService;
    @Autowired
    CommonUtils utils;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private UserDao userDao;
    @Autowired
    DesUtil desUtil;

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
        user.setPassword(desUtil.encrypt(user.getPassword()));
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

    public String[] createValidateImg(HttpServletRequest request) throws IOException{
        String requestId = request.getRequestedSessionId();
        String randomNum = utils.get3RandomNum();
        ValidateCode validateCode = new ValidateCode();
        String pathRoot = request.getSession().getServletContext().getRealPath("/");
        String pathSuffix = "static/img/validate/"+requestId+randomNum+".png";
        String path = pathRoot + pathSuffix;
        String url = "../../../../static/img/validate/"+requestId+randomNum+".png";
        Object[] obj = validateCode.createImage();
        String code = (String) obj[0];
        BufferedImage image = (BufferedImage) obj[1];
        OutputStream os = new FileOutputStream(path);
        ImageIO.write(image, "png", os);
        os.close();
        HttpSession session = request.getSession();
        String oldPath = (String)session.getAttribute("path");
        if (oldPath != null){
            File file = new File(oldPath);
            file.delete();
        }
        session.setAttribute("path",path);
        return new String[]{code,url};
    }

    public User login(String account, String password) {
        User user = userDao.selectByAccount(account);
        if (desUtil.decrypt(user.getPassword()).equals(password)){
            return user;
        }else
            return null;
    }

    /**
     * 设置自动登录cookie，将token存入redis
     * */
    public Cookie setLoginCookie(String auto, User user) {
        //设置自动登录有效时间
        int deadline = 60;
        String token = desUtil.encrypt(user.getuId());
        Cookie cookie = new Cookie("token",token);
        cookie.setPath("/");
        if (auto.equals("true")){
            cookie.setMaxAge(deadline);
            redisUtil.set(token,user,deadline);
        }else {
            cookie.setMaxAge(0);
            if (redisUtil.hasKey(token))
                redisUtil.del(token);
        }

        return cookie;
    }

    public User selectByUid(String uId) {
        return userDao.selectByPrimaryKey(uId);
    }

    public User autoLogin(String token) {
        if(redisUtil.hasKey(token)){
            return (User)redisUtil.get(token);
        }
        return null;
    }

    public Cookie logout(User user) {
        String token = desUtil.encrypt(user.getuId());
        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(0);
        if (redisUtil.hasKey(token))
            redisUtil.del(token);
        return cookie;
    }


}
