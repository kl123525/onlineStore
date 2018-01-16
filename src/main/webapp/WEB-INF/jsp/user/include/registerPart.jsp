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
        <form action="#" method="post" id="mobile-register-form" class="validate">
            <div class="reg-form">
                <div class="form-group">
                    <div class="form-item">
                        <span class="form-label tsl" data-phase-id="r_p_mobileNum" style="cursor:default">手机号</span>
                        <div class="mobile-text">
                            <input type="text" class="mobile-input form-control" name="mobile" id="mobile-num-txt" maxlength="11" placeholder="请输入您的手机号码">
                            <span id="pnum-info" style="color: red;position: absolute"></span>
                        </div>
                    </div>
                    <div class="form-item">
                        <span class="form-label tsl" data-phase-id="r_p_noCaptcha" style="cursor:default">验证码</span>
                        <div class="mobile-text" style="">
                            <input type="text" class="mobile-input form-control" name="validate_sms_code" id="validate-sms-code-txt" maxlength="6" datatype="int" style=" float: left;"><span class="tip ok" style="color:#a94442;font-size: 12px; top: 5px; position: absolute; left: 0px;"></span>
                            <input type="button" class="btn btn-info send-sms-btn" id="send-sms-button" value="发送验证码">
                            <span id="sms-info" style="color: red"></span>
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
    </div>
</div>
