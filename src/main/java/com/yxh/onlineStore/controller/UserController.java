package com.yxh.onlineStore.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.DaYuService;
import com.yxh.onlineStore.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨旭晖 on 2018/1/12.
         */
@Controller
@RequestMapping("user")
public class UserController {
    private DaYuService daYuService = new DaYuService();
    private RedisUtil redisUtil = new RedisUtil();
    @Autowired
    private UserService userService;

    @RequestMapping("homePage/{token}/{cartInfo}")
    public String homePage(@PathVariable("token") String token,@PathVariable("cartInfo") String cartInfo){
        if (!token.equals("null")){
            //TODO 查询redis是否有此token，若有则查询user写入session，查询购物车
            if (!cartInfo.equals("null")){
                //TODO 合并购物车并写入数据库、Cookie
            }
        }
        return "/home";
    }

    @RequestMapping("sendPhoneCode")
    @ResponseBody
    public void sendPhoneCode(@RequestBody Map<String,String> phoneNum){
        Map<Boolean,String> map;
        //发送验证码
        String phone = phoneNum.get("phoneNum");
        map = daYuService.sendPhoneCode(phone);
        if(map.containsKey(true)) {
            System.out.println(redisUtil.set(phone,map.get(true),180));
        }
    }

    @RequestMapping("registerPage")
    public String registerPage() { return "user/register"; }
    @RequestMapping("loginPage")
    public String loginPage() { return "user/login"; }

    @RequestMapping("register")
    public String register(User user){
        userService.insertUser(user);
        return "user/login";
    }

    @RequestMapping("login")
    public String login(){
        return "";
    }

}
