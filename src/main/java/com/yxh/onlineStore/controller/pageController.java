package com.yxh.onlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 杨旭晖 on 2018/1/12.
 */
@Controller
@RequestMapping("")
public class pageController {
    @RequestMapping("registerPage")
    public String registerPage() {return "user/register"; }
    @RequestMapping("loginPage")
    public String loginPage() { return "user/login"; }
}
