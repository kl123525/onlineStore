package com.yxh.onlineStore.controller;

import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨旭晖 on 2018/1/12.
         */
@Controller
@RequestMapping("user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    private RedisUtil redisUtil = new RedisUtil();
    @Autowired
    private UserService userService;

    @RequestMapping("homePage")
    public String homePage(){ return "/home"; }

    @RequestMapping("homePage/{token}/{cartInfo}")
    public ModelAndView homePage(@PathVariable("token") String token,@PathVariable("cartInfo") String cartInfo,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home");
        if (!token.equals("null")){
            //TODO 查询redis是否有此token，若有则查询user写入session，查询购物车
            User user = userService.autoLogin(token);
            HttpSession session = request.getSession();
            if (user != null){
                session.setAttribute("user",user);
                return mv;
            }
        }
        if (!cartInfo.equals("null")){
        //TODO 合并购物车并写入数据库、Cookie
    }
    return mv;
}

    @RequestMapping("test")
    public ModelAndView test(){
        String uId = "0012018011815480800037148";
        ModelAndView mv = new ModelAndView();
        User user = userService.selectByUid(uId);
        mv.setViewName("user/test");
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("sendPhoneCode")
    @ResponseBody
    public boolean sendPhoneCode(@RequestBody Map<String,String> phoneNum){
        String phone = phoneNum.get("phoneNum");
        return userService.sendPhoneCode(phone);
    }

    @RequestMapping("testPhoneCode")
    @ResponseBody
    public Map<String,String> testPhoneCode(@RequestBody Map<String,String> request){
        Map<String,String> response = new HashMap<String, String>();
        String phoneCode = request.get("code");
        String phoneNum = request.get("phoneNum");
        String redisCode = (String) redisUtil.get(phoneNum);
        if (phoneCode.equals(redisCode)){
            redisUtil.del(phoneNum);
            response.put("true",phoneNum);
            return response;
        }else {
            response.put("false","");
            return response;
        }
    }

    @RequestMapping("login")
    @ResponseBody
    public boolean login(String account,String password,String auto, HttpServletRequest request, HttpServletResponse response){
        User user = userService.login(account,password);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            Cookie cookie = userService.setLoginCookie(auto,user);
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        session.removeAttribute("user");
        Cookie cookie = userService.logout(user);
        response.addCookie(cookie);
        return "/home";
    }

    @RequestMapping("register")
    @ResponseBody
    public Boolean register(@RequestBody User user){
        int result = userService.insertUser(user);
        return result == 1;
    }

    @RequestMapping("changeValidateImg")
    @ResponseBody
    public Map<String,String> changeValidateImg(HttpServletRequest request) throws IOException{
        Map<String,String> response = new HashMap<String, String>();
        String[] str = userService.createValidateImg(request);
        response.put("Code",str[0]);
        response.put("Url",str[1]);
        return response;
    }


    @RequestMapping("registerPage")
    public String registerPage() { return "user/register"; }
    @RequestMapping("loginPage")
    public ModelAndView loginPage(HttpServletRequest request)throws IOException {
        String[] str = userService.createValidateImg(request);
        ModelAndView mv = new ModelAndView();
        mv.addObject("code",str[0]);
        mv.addObject("url",str[1]);
        mv.setViewName("user/login");
        return mv;
    }



}
