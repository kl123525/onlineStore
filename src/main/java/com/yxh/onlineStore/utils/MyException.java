package com.yxh.onlineStore.utils;

/**
 * Created by 杨旭晖 on 2017/12/11.
 * 自定义mongoDao exception
 */
public class MyException extends Exception{

    public MyException(String message) {
        super(message);
    }
}
