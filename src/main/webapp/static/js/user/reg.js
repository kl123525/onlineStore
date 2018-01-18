$(document).ready(function () {
    var isSuccess = false;
    $(".mobile-register-form").show();
    $(".user-info-form").hide();
    $("#reg-isSuccess").hide();
    $("#isSuccess").hide();
    $("#notSuccess").hide();
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    $("#send-sms-button").click(function () {
        var test = /^1[3|4578][0-9]{9}$/;
        var phoNum = $("#mobile-num-txt").val();
        var flag = test.test(phoNum);
        if (!flag){
            $("#pnum-info").text("请输入正确的手机号码!");
            $("#mobile-num-txt").css(errorBorder);
        } else {
            $("#sms-info").text("");
            $("#mobile-num-txt").css(normalBorder);
            sendMessage(phoNum);
        }
    });
    function sendMessage(phoNum) {
        var json = {"phoneNum":phoNum};
        $.ajax({
            method : "POST",
            contentType: "application/json",
            url : "/user/sendPhoneCode",
            data : JSON.stringify(json),
            dataType : "json",
            success:function (data) {
                if (data){
                    $("#mobile-num-txt").css(normalBorder);
                    $("#pnum-info").text("");
                    curCount = count;
                    //设置button效果，开始计时
                    $("#send-sms-button").attr("disabled", "true").val("已发送 " + curCount + " 秒");
                    InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
                }else{
                    $("#mobile-num-txt").css(errorBorder);
                    $("#pnum-info").text("此手机号已被注册!");
                }
            }
        });
    }

    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#send-sms-button").removeAttr("disabled").val("重新发送");
        }
        else {
            curCount--;
            $("#send-sms-button").val("已发送 " + curCount + " 秒");
        }
    }

    $("#first-step-button").click(function () {
        var code = $("#validate-sms-code-txt").val();
        var phoneNum = $("#mobile-num-txt").val();
        var json = {"code" : code,"phoneNum" : phoneNum};
        $.ajax({
            method : "POST",
            contentType: "application/json",
            url : "/user/testPhoneCode",
            data : JSON.stringify(json),
            dataType : "json",
            success:function (data) {
                if (data.true != null){
                    $("#sms-info").text("");
                    $("#validate-sms-code-txt").css(normalBorder);
                    $(" input[ name='mobilenum'] ").val(data.true);
                    $(".mobile-register-form").hide();
                    $(".user-info-form").show();
                    $(".steps ol li").eq(1).addClass("active");
                }else{
                    $("#sms-info").text("验证码错误");
                    $("#validate-sms-code-txt").css(errorBorder);
                }
            }
        })
   });



    $("#second-step-button").click(function () {
        checkUserInfo();
        if (flag1 && flag2 && flag3 && flag4){
            var account = $(" input[ name='mobilenum'] ").val();
            var sex = $("#sex").val();
            var nickName = $("#username-text").val();
            var password = $("#password-ps").val();

            var json = {"account":account,"sex":sex,"nickName":nickName,"password":password};
            $.ajax({
                method : "POST",
                contentType: "application/json",
                url : "/user/register",
                data : JSON.stringify(json),
                dataType : "json",
                success:function (data) {
                    $(".user-info-form").hide();
                    $("#reg-isSuccess").show();
                    $(".steps ol li").eq(2).addClass("active");
                    if (data){
                        $("#isSuccess").show();
                        $(".steps ol li").eq(3).addClass("active");
                    }else{
                        $("#notSuccess").show();
                    }
                }
            })
        }
    });

});

/*------------------------------------------- 注册信息验证 --------------------------------------------------------*/
var flag1 = false;
var flag2 = false;
var flag3 = false;
var flag4 = false;
var testPsw = /^[\w-`~!@#$%^&*]{6,12}$/;
var testUsername = /^[A-Za-z0-9\u4e00-\u9fa5]{3,10}$/;
var null_error = "此项为必填";
var psw_error = "密码为6-12位字母、数字、特殊符号";
var repsw_error = "两次密码不匹配";
var errorBorder = {"border":"1px solid #d1a6a5"};
var normalBorder = {"border": "1px solid #ccc"};
function checkSex() {
    var sex = $("#sex").val();
    //验证性别
    if (sex == null){
        $(".sex-error-msg").text(null_error);
        $("#sex").css(errorBorder);
        flag1 = false;
    } else {
        $(".sex-error-msg").text("");
        $("#sex").css(normalBorder);
        flag1 = true;
    }
}
function checkNickname() {
    var nickName = $("#username-text").val();
    //昵称确认
    if(nickName == ""){
        $("#username-text").css(errorBorder);
        flag2 == false;
    }else{
        if(testUsername.test(nickName)){
            $("#username-text").css(normalBorder);
            flag2 = true;
        }else{
            $("#username-text").css(errorBorder);
            flag2 = false;
        }
    }
}
function checkPassword() {
    var password = $("#password-ps").val();
    //验证密码
    if (password == ""){
        $(".psw-error-msg").text(null_error);
        $("#password-ps").css(errorBorder);
        flag3 = false;
    }else{
        $(".psw-error-msg").text("");
        if (testPsw.test(password)){
            $(".psw-error-msg").text("");
            $("#password-ps").css(normalBorder);
            flag3 = true;
        }else{
            $(".psw-error-msg").text(psw_error);
            $("#password-ps").css(errorBorder);
            flag3 = false;
        }
    }
}
function checkRepassword() {
    var password = $("#password-ps").val();
    var repasswprd = $("#repassword-ps").val();
    //验证密码确认
    if(repasswprd == ""){
        $(".repsw-error-msg").text(null_error);
        $("#repassword-ps").css(errorBorder);
        flag4 = false;
    }else{
        $(".repsw-error-msg").text("");
        if (password == repasswprd){
            $(".repsw-error-msg").text("");
            $("#repassword-ps").css(normalBorder);
            flag4 = true;
        }else{
            $(".repsw-error-msg").text(repsw_error);
            $("#repassword-ps").css(errorBorder);
            flag4 = false;
        }
    }
}
function checkUserInfo() {
    checkSex();
    checkNickname();
    checkPassword();
    checkRepassword();
}