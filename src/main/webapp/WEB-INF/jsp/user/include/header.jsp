<%--
  Created by IntelliJ IDEA.
  User: YangXuhui
  Date: 2018/1/12
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class = "header">
    <div class="login-info">
        <p class = "hp-back-home">商城首页</p>
        <c:when test="${empty sessionScope.userNname}">
            <p>欢迎来到电子商城!</p>
            <a class="hp-login" href="/user/loginPage">请登录</a>
            <a class="hp-register" href="/user/registerPage">免费注册</a>
        </c:when>
        <c:otherwise>
            <p>Hi, ${sessionScope.userNname}</p>
            <a class="hp-userPoint">积分 ${point}</a>
            <a class="hp-logout" href="">退出</a>
        </c:otherwise>
    </div>
    <div class="quick-menu">
        <dl class><dt><a target="_blank" href="/sellerPage">商家中心</a></dt></dl>
        <dl class>
            <dt><a href="/user/orderPage/<%=token%>">我的订单</a></dt>
        </dl>
    </div>
</div>