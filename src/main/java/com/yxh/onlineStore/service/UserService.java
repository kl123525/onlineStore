package com.yxh.onlineStore.service;

        import com.yxh.onlineStore.po.User;

        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
        import java.io.IOException;

/**
 * Created by 杨旭晖 on 2018/1/14.
 */
public interface UserService {

    int insertUser(User user);

    boolean sendPhoneCode(String mobileNum);

    String[] createValidateImg(HttpServletRequest request) throws IOException;

    User login(String account,String password);

    Cookie setLoginCookie(String auto, User user);

    User selectByUid(String uId);

    User autoLogin(String token);

    Cookie logout(User user);
}
