package com.yxh.onlineStore.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by 杨旭晖 on 2018/1/16.
 */
public class test {


    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(2);
        jedisPoolConfig.setMaxTotal(20);
        String host = "139.199.207.90";
        int port = 6379;
        String password = "123456";
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,2000,password);
        Jedis jedis = jedisPool.getResource();
        jedis.set("info","message");
        System.out.println(jedis.get("info"));
        jedisPool.close();
    }

}
