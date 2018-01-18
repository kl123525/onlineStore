
$(document).ready(function () {
    $(".login-tips").hide();
    /*------------------------  登录   ---------------------------*/
   $("#login").click(function () {
       var testPsw = /^[\w-`~!@#$%^&*]{6,12}$/;
       var account = $("#account").val();
       var password = $("#password").val();
       var inputCode = $("#validcode").val();
       var trueCode =  $(" input[ id='code'] ").val();
       if ((account != null) && (testPsw.test(password)) && (inputCode == trueCode)){
           $(".login-tips").hide();
           var json = {"account":account,"password":password};
           $.ajax({
               method : "POST",
               contentType: "application/json",
               url : "/user/login",
               data : JSON.stringify(json),
               dataType : "json",
               success:function (data) {
                   if (data){
                       alert("登陆成功");
                   }else {
                       $(".tips-content").text("账号或密码错误");
                       $(".login-tips").show();
                   }
               }
           })
       }else if (account == null){
          $(".tips-content").text("请填写手机号");
           $(".login-tips").show();
       }else if (!testPsw.test(password)){
           $(".tips-content").text("密码个事不正确");
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
});