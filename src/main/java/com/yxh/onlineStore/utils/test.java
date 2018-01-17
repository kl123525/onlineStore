package com.yxh.onlineStore.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 杨旭晖 on 2018/1/17.
 */
public class test {

    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        System.out.println(timestamp);
    }
}
