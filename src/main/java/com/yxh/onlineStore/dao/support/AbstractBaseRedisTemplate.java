package com.yxh.onlineStore.dao.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by 杨旭晖 on 2018/1/16.
 */
public class AbstractBaseRedisTemplate implements ApplicationContextAware {
    protected RedisTemplate redisTemplate;

    private void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RedisTemplate redisTemplate = applicationContext.getBean("redisTemplate", RedisTemplate.class);
        setRedisTemplate(redisTemplate);
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public static void main(String[] args) {
        AbstractBaseRedisTemplate abstractBaseRedisTemplate = new AbstractBaseRedisTemplate();
        RedisTemplate redisTemplate = abstractBaseRedisTemplate.redisTemplate;
        redisTemplate.opsForValue().set("123","123");
    }
}
