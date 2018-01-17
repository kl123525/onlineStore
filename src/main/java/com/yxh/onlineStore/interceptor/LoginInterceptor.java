package com.yxh.onlineStore.interceptor;

import com.yxh.onlineStore.po.Seller;
import com.yxh.onlineStore.po.User;
import com.yxh.onlineStore.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by 杨旭晖 on 2018/1/14.
 * 拦截器，验证需要登录才能访问的页面
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    //@Autowired
    //CartService cartService;
    //@Autowired
    //OrderService orderService;
    //@Autowired
    //ProductService productService;
    //@Autowired
    //SellerService sellerService;
    //@Autowired
    //StoreService storeService;
    @Autowired
    UserService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        /**
         * 不需要验证的url
         * */
        String[] noNeedAuthPage = new String[]{
                "loginPage",
                "homePage",
                "registerPage",
                "index",
                "sendPhoneCode",
                "testPhoneCode",
                "login",
                "register"
        };

        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri,contextPath);
        if (uri.startsWith("/user")){
            String method = StringUtils.substringAfterLast(uri,"user/");
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                User user =(User) session.getAttribute("user");
                if(null==user){
                    response.sendRedirect("/user/loginPage");
                    return false;
                }
            }
        }
        if (uri.startsWith("/seller")){
            String method = StringUtils.substringAfterLast(uri,"seller/");
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                Seller seller = (Seller)session.getAttribute("seller");
                if (null == seller){
                    response.sendRedirect("/seller/loginPage");
                }
            }
        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
