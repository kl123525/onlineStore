package com.yxh.onlineStore.controller;

import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
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

    @RequestMapping("register")
    @ResponseBody
    public Boolean register(@RequestBody User user){
        int result = userService.insertUser(user);
        return result == 1;
    }


    @RequestMapping("registerPage")
    public String registerPage() { return "user/register"; }
    @RequestMapping("loginPage")
    public String loginPage() { return "user/login"; }



}
