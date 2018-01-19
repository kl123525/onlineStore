package com.yxh.onlineStore.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
@Component
public class CommonUtils {

    /**
     * 字符串首字母大写
     * @param str 待处理字符串
     * @return String
     * */
    public String firstChToUpperCase(String str){
        char[] ch = str.toCharArray();
        if(ch[0] >= 'A' && ch[0] <= 'Z'){
            ch[0]-= 32;
            return String.valueOf(ch);
        }
        return str;
    }

    /**
     * 字符串首字母小写
     * @param str 待处理字符串
     * @return String
     * */
    public String firstChToLowerCase(String str){
        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0]-= 32;
            return String.valueOf(ch);
        }
        return str;
    }

    public Method findMethodByName(Object obj,String methodName){
        Class cla = obj.getClass();
        Method m;
        try {
            m = cla.getMethod(methodName);
            return m;
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前线程id，5位左侧补零
     * */
    public String getThreadId(){
        Long tId = Thread.currentThread().getId();
        return String.format("%05d",tId);
    }

    /**
     *获取当前时间戳，14位
     * */
    public String getTimestamp(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    /**
     * 获取0-999随机数，不足三位左侧补零
     * */
    public String get3RandomNum(){
        int randomNum = (int)(0 + Math.random()*999);
        return String.format("%03d",randomNum);
    }
    /**
     * 获取当前时间timestamp
     * */
    public Timestamp getMysqlDate(){
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        return timestamp;
    }
    /**
     * 生成用户登录token
     * */
}
