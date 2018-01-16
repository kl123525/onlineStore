package com.yxh.onlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 杨旭晖 on 2018/1/15.
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("/orderPage/{token}")
    public ModelAndView showOrder(@PathVariable("token") String token){
        ModelAndView mv = new ModelAndView();
        return mv;
    }

}
