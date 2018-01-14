package com.yxh.onlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 杨旭晖 on 2018/1/14.
 */
@Controller
@RequestMapping("seller")
public class sellerController {

    @RequestMapping("sellerPage")
    public String sellerPage() { return "seller/center"; }
    @RequestMapping("loginPage")
    public String loginPage() { return "seller/login"; }
    @RequestMapping("registerPage")
    public String registerPage() { return "seller/register"; }

}
