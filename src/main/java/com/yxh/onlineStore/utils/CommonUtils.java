package com.yxh.onlineStore.utils;

import java.lang.reflect.Method;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
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
}
