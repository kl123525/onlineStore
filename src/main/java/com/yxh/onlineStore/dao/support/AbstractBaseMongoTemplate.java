package com.yxh.onlineStore.dao.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
public class AbstractBaseMongoTemplate implements ApplicationContextAware {
    protected MongoTemplate mongoTemplate;

    private void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        MongoTemplate mongoTemplate = applicationContext.getBean("mongoTemplate", MongoTemplate.class);
        setMongoTemplate(mongoTemplate);
    }
}
