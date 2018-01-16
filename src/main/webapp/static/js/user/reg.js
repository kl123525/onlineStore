$(document).ready(function () {
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    $("#send-sms-button").click(function () {
        var test = /^1[3|4578][0-9]{9}$/;
        var phoNum = $("#mobile-num-txt").val();
        var flag = test.test(phoNum);
        if (!flag){
            $("#sms-info").text("请输入正确的手机号码!");
        } else {
            $("#sms-info").text("");
            sendMessage(phoNum);
        }
    });
    function sendMessage(phoNum) {
        curCount = count;
        //设置button效果，开始计时
        $("#send-sms-button").attr("disabled", "true");
        $("#send-sms-button").val("已发送 " + curCount + " 秒");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
        var json = {"phoneNum":phoNum};
        $.ajax({
            method : "POST",
            contentType: "application/json",
            url : "/user/sendPhoneCode",
            data : JSON.stringify(json),
            dataType : "json"
        });
    }

//timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#send-sms-button").removeAttr("disabled");//启用按钮
            $("#send-sms-button").val("重新发送");
        }
        else {
            curCount--;
            $("#send-sms-button").val("已发送 " + curCount + " 秒");
        }
    }

    $("#first-step-button").click(function () {
       
   }); 
});