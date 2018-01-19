<%--
  Created by IntelliJ IDEA.
  User: YangXuhui
  Date: 2018/1/12
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header-wrapper">
    <div class = "header">
        <div class="login-info">
            <p class = "hp-back-home">商城首页</p>
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <p>欢迎来到电子商城!</p>
                    <a class="hp-login" href="/user/loginPage">请登录</a>
                    <a class="hp-register" href="/user/registerPage">免费注册</a>
                </c:when>
                <c:otherwise>
                    <p>Hi, ${sessionScope.user.nickName}</p>
                    <a class="hp-logout" href="/user/logout">退出</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="quick-menu">
            <dl class="undone"><dt><a target="_blank" href="seller/sellerPage">商家中心</a></dt></dl>
            <dl class="undone">
                <%
                    Cookie[] cookies = request.getCookies();
                    String token = null;
                    if (cookies != null) {
                        for(int i=0; i<cookies.length; i++) {
                            // 获得具体的Cookie
                            Cookie cookie = cookies[i];
                            if ("token".equals(cookie.getName())){
                                token = cookie.getValue();
                            }
                        }
                    }
                %>
                <dt><a href="/order/orderPage/<%=token%>">我的订单</a></dt>
            </dl>
            <dl class="undone"><dt><a href="#">我的收藏</a> </dt></dl>
            <dl class="undone"><dt><a href="#">站点导航</a> </dt></dl>
            <dl class="undone"><dt><a href="#">站内消息</a> </dt></dl>
        </div>
    </div>
</div>
