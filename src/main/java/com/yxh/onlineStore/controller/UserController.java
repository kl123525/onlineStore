package com.yxh.onlineStore.controller;

import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.UserService;
import com.yxh.onlineStore.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("login")
    @ResponseBody
    public boolean login(@RequestBody User user, HttpServletRequest request){
        User user1 = userService.login(user.getAccount(),user.getPassword());
        if (user1 != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user1);
            return true;
        }
        return false;
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
        HttpSession session = request.getSession();
        String oldPath = (String)session.getAttribute("path");
        File file = new File(oldPath);
        file.delete();
        session.setAttribute("path",str[2]);
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
        request.getSession().setAttribute("path",str[2]);
        return mv;
    }



}
