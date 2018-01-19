
$(document).ready(function () {
    $(".login-tips").hide();
    $("#auto-login").click(function () {
       alert("1分钟自动登录时间用做测试 \n 登陆成功时会根据uId生成token存入redis \n 请在一分钟内关闭浏览器重新打开验证自动登录功能")
    });
    var InterValObj;
    var curCount;
    /*------------------------  登录   ---------------------------*/
   $("#login").click(function () {
       var testPsw = /^[\w-`~!@#$%^&*]{6,12}$/;
       var account = $("#account").val();
       var password = $("#password").val();
       var inputCode = $("#validcode").val();
       var trueCode =  $(" input[ id='code'] ").val();
       var autoLogin = $(" input[ id='auto-login'] ").is(':checked');
       if ((account != null) && (testPsw.test(password)) && (inputCode.toLowerCase() == trueCode.toLowerCase())){
           $(".login-tips").hide();
           var json = {"account":account,"password":password,"auto":autoLogin};
           $.ajax({
               method : "POST",
               url : "/user/login",
               data : json,
               dataType : "json",
               success:function (data) {
                   if (data) {
                       $(".login-img").hide();
                       $(".login-tools").hide();
                       $(".login-success").show();
                       curCount = 5;
                       InterValObj = window.setInterval(jumpingHome, 1000);
                   } else {
                       $.ajax({
                           method: "POST",
                           contentType: "application/json",
                           url: "/user/changeValidateImg",
                           cache: false,
                           dataType: "JSON",
                           success: function (data) {
                               if (data != null) {
                                   $(" input[ id='code'] ").val(data.Code);
                                   $(".code_img").attr('src', data.Url);
                               }
                           }
                       });
                       $(".tips-content").text("账号或密码错误");
                       $(".login-tips").show();
                   }
               }
           })
       }else if (account == null){
          $(".tips-content").text("请填写手机号");
           $(".login-tips").show();
       }else if (!testPsw.test(password)){
           $(".tips-content").text("密码格式不正确");
           $(".login-tips").show();
       }else if (inputCode != trueCode){
           $(".tips-content").text("验证码错误");
           $(".login-tips").show();
       }
   });
    /*------------------------  换验证码   ---------------------------*/
   $(".changeImg").click(function () {
      $.ajax({
          method : "POST",
          contentType: "application/json",
          url : "/user/changeValidateImg",
          cache:false,
          dataType: "JSON",
          success:function (data) {
              if (data != null){
                  $(" input[ id='code'] ").val(data.Code);
                  $(".code_img").attr('src',data.Url);
              }
          }
      })
   });
    function jumpingHome(){
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            window.location.href="/user/homePage";
        }
        else {
            curCount--;
        }
    }
});
