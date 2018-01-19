<%--
  Created by IntelliJ IDEA.
  User: YangXuhui
  Date: 2018/1/16
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="login-wrapper">
    <div class="login-img"></div>
    <div class="login-tools">
        <div class="login-tips"><p class="tips-content"></p></div>
        <div class="login-type" style="cursor:default">用户登录</div>
        <div class="login-content">
            <label class="normal-item">
                <i></i>
                <input type="text" tabindex="1" placeholder="手机号" name="account" id="account" class="definition_small same_input" onblur="checkAccount()">
            </label>
            <label class="normal-item">
                <i></i>
                <input type="password" tabindex="2" placeholder="密码" name="password" id="password" class="definition_small same_input">
            </label>
            <label class="normal-item">
                <i></i>
                <input type="text" tabindex="3" placeholder="验证码" name="code" id="validcode" class="definition_small same_input">
                <input type="hidden" value="${code}" id = "code">
                <img src="${url}" alt="会员登录验证码" class="code_img changeImg" style="cursor: pointer;">
                <a class="changeImg" id="changeImg">看不清楚?换一张</a>
            </label>
            <div class="normal-item">
                <input type="checkbox" name="auto-login" id="auto-login">
                <p style="cursor:default; display: inline-block">一分钟内免登录</p>
                <a href="#" style="display: inline-block;color: red;margin-left:80px">忘记密码?</a>
            </div>
            <div class="normal-item">
                <input type="button" tabindex="4" name="login" id="login" value="登  录">
            </div>
        </div>
    </div>
    <div class="login-success" style="display: none">
        <h1 style="text-align: center">登录成功！</h1>
        <div style="text-align: center">
            <a href="/user/homePage" style="font-size: 16px ">即将跳转至首页</a>
        </div>
    </div>
</div>
