<%--
  Created by IntelliJ IDEA.
  User: YangXuhui
  Date: 2018/1/16
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="register-wrapper">
    <div class="steps steps-4">
        <ol>
            <li class="active"><i>1</i><span class="tsl" data-phase-id="r_p_createAccount" style="cursor:default">填写手机号</span></li>
            <li><i>2</i><span class="tsl" data-phase-id="r_p_fillUserInfo" style="cursor:default">填写账号信息</span></li>
            <li style="cursor:default"><i class="iconfont">✔</i><span>注册成功</span></li>
        </ol>
    </div>
    <div class="reg-content">
        <form action="#" method="post" class="mobile-register-form validate">
            <div class="reg-form">
                <div class="form-group">
                    <div class="form-item">
                        <span class="form-label tsl" data-phase-id="r_p_mobileNum" style="cursor:default">手机号</span>
                        <div class="mobile-text">
                            <input type="text" class="mobile-input form-control" name="mobile" id="mobile-num-txt" maxlength="11" placeholder="请输入您的手机号码">
                            <span id="pnum-info" style="color: #c47e7d;position: absolute"></span>
                        </div>
                    </div>
                    <div class="form-item">
                        <span class="form-label tsl" data-phase-id="r_p_noCaptcha" style="cursor:default">验证码</span>
                        <div class="mobile-text" style="">
                            <input type="text" class="mobile-input form-control" name="validate_sms_code" id="validate-sms-code-txt" maxlength="6" datatype="int" style=" float: left;"><span class="tip ok" style="color:#a94442;font-size: 12px; top: 5px; position: absolute; left: 0px;"></span>
                            <input type="button" class="btn btn-info send-sms-btn" id="send-sms-button" value="发送验证码">
                            <span id="sms-info" style="color: #c47e7d"></span>
                        </div>
                    </div>
                    <div class="form-item form-item-short" style="cursor:default">
                        <input id="license" type="checkbox" checked="checked" name="license" value="agree" style="margin-right:10px;">已阅读并同意<span class="protocol undone">服务协议</span>
                    </div>
                    <div class="form-item form-item-short">
                        <a class="btn btn-danger" id="first-step-button">下一步</a>
                    </div>
                </div>
            </div>
        </form>
        <form id="user-info-form"  method="post" class="user-info-form validate">
            <div class="form-list form-main-list">
                <div class="form-group">
                    <div class="form-item" style="margin-top:10px;">
                        <span class="form-label tsl">账户</span>
                        <div class="mobile-text">
                            <input id="mobile-text account" class="form-control mobile-input" type="text" name="mobilenum" placeholder="" value="" disabled isrequired="true">
                        </div>
                    </div>
                    <div class="form-item" style="margin-top:10px;">
                        <span class="form-label tsl">性别</span>
                        <div class="mobile-text">
                            <select id="sex" class="form-control mobile-input" name="sex" style="margin-top: 0" onblur=checkSex()>
                                <option disabled selected>--- 请选择性别 ---</option>
                                <option>男</option>
                                <option>女</option>
                            </select>
                            <span class="error-msg sex-error-msg"></span>
                        </div>
                    </div>
                    <div class="form-item" style="margin-top:10px;">
                        <span class="form-label tsl" data-phase-id="r_p_mobileNum">会员名</span>
                        <div class="mobile-text">
                            <input id="username-text" class="form-control mobile-input" name="username" placeholder="一旦设置，不能再修改" type="text" isrequired="true" onblur=checkNickname()>
                            <span class="error-msg username-error-msg">长度只能在3-10个字符之间</span>
                        </div>
                    </div>
                    <div class="form-item" style="margin-top:10px;">
                        <span class="form-label tsl">登录密码</span>
                        <div class="mobile-text">
                            <input id="password-ps" class="form-control mobile-input" name="password" placeholder="设置您的登录密码" type="password" isrequired="true" onblur=checkPassword()>
                            <span class="error-msg psw-error-msg"></span>
                        </div>
                    </div>
                    <div class="form-item" style="margin-top:10px;">
                        <span class="form-label tsl">密码确认</span>
                        <div class="mobile-text">
                            <input id="repassword-ps" class="form-control mobile-input" name="repassword" placeholder="请再次输入您的密码" type="password" isrequired="true" onblur=checkRepassword()>
                            <span class="error-msg repsw-error-msg"></span>
                        </div>
                    </div>

                    <div class="form-item form-item-short">
                        <input style="width:226px;margin: 20px 0 0 230px;background-color: #d9534f;color: white" type="button" id="second-step-button" class="btn btn-large tsl" value="提交">
                    </div>
                </div>
            </div>
        </form>
        <div id="reg-isSuccess">
            <div id="isSuccess"><h1>注册成功！</h1></div>
            <div id="notSuccess"><h1>注册失败!</h1></div>
        </div>
    </div>
</div>
