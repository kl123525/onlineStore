package com.yxh.onlineStore.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 杨旭晖 on 2018/1/16.
 */
@Component
public class DaYuService {

    /**
     * 获取IAcsClient对象
     *
     * @return
     * @throws ClientException
     */
    private static IAcsClient initClient() throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // 初始化ascClient需要的几个参数
        final String product = "Dysmsapi";// 短信API产品名称
        final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名
        // 秘钥key和secret
        final String appkey = "LTAItOKldfJGrRbf";
        final String appSecret = "QBAJXe3RO4gwio1rC0piKdu2L3hcGw";
        // 初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", appkey, appSecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        return acsClient;
    }

    /**
     * 发送6位随机验证码
     * @param telphone 手机号码
     * @return 返回短信发送状态，如果成功返回验证码
     */
    public Map<Boolean,String> sendPhoneCode(String telphone) {
        Map<Boolean,String> map = new HashMap<Boolean, String>();
        try {
            //随机生成6位数验证码
            int code = (int)(1 + Math.random()*999999);
            String randomCode = String.format("%06d",code);
            // 初始化client对象
            IAcsClient client = initClient();
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为20个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(telphone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("JAVA示例商城");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode("SMS_121851323");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam("{\"code\":\"" + randomCode + "\"}");
            // 发送短信
            SendSmsResponse response = client.getAcsResponse(request);
            // 打印短信的消息
            System.out.println("_____________发送短信收到的响应信息_______________");
            System.out.println("请求的ID:" + response.getRequestId());
            System.out.println("请求的状态码:" + response.getCode());
            System.out.println("请求的状态码描述:" + response.getMessage());
            System.out.println("请求的回执ID:" + response.getBizId());
            if (response.getCode().equals("OK")) {
                map.put(true,randomCode);
                return map;
            } else {
                map.put(false,"");
                return map;
            }
        }catch (ClientException e){
            e.printStackTrace();
            map.put(false,"");
            return map;
        }
    }

    /**
     * 发送请求回执
     * @param telphone 手机号码
     * @param surName 姓氏
     * @param sex 先生or女士
     */
    public void sendMessage(String telphone,String surName,String sex,String operation) {
        try {
            // 初始化client对象
            IAcsClient client = initClient();
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为20个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(telphone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("JAVA示例商城");
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode("SMS_121907652");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam("{\"surname\":\"" + surName + "\",\"sex\":\"" + sex + "\",\"operation\":\"" + operation + "\"}");
            // 发送短信
            SendSmsResponse response = client.getAcsResponse(request);
            // 打印短信的消息
            System.out.println("_____________发送短信收到的响应信息_______________");
            System.out.println("请求的ID:" + response.getRequestId());
            System.out.println("请求的状态码:" + response.getCode());
            System.out.println("请求的状态码描述:" + response.getMessage());
            System.out.println("请求的回执ID:" + response.getBizId());
        }catch (ClientException e){
            e.printStackTrace();
        }
    }

}
