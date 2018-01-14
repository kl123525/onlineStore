package com.yxh.onlineStore.controller;

import com.yxh.onlineStore.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 杨旭晖 on 2018/1/12.
         */
@Controller
@RequestMapping("user")
public class userController {

    @RequestMapping("registerPage")
    public String registerPage() { return "user/register"; }
    @RequestMapping("loginPage")
    public String loginPage() { return "user/login"; }

    @RequestMapping("/orderPage/{token}")
    public ModelAndView showOrder(@PathVariable("token") String token){
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login(User user){

    }

}
