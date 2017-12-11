package com.yxh.onlineStore.utils;

import com.yxh.onlineStore.po.Sku;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
public class MongoUtils {

    private CommonUtils commonUtils = new CommonUtils();

    /**
     * 根据pojo实例和多个条件参数名取得query
     * @param obj pojo
     * @param params 条件参数名数组
     * */
    public Query getQuery(Object obj, String[] params){
        Query query = new Query();
        Criteria criteria;
        for (String param:params) {
            String methodName = "get" + commonUtils.firstChToUpperCase(param);
            Method m = commonUtils.findMethodByName(obj,methodName);
            try{
                m.invoke(obj);
                criteria = Criteria.where(commonUtils.firstChToLowerCase(param)).gt(m.invoke(obj));
                query.addCriteria(criteria);
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }catch (IllegalAccessException e1){
                e1.printStackTrace();
            }
        }
        return query;
    }

    /**
     * 根据pojo实例和单个条件参数名取得query
     * @param obj pojo
     * @param param 条件参数名
     * */
    public Query getQuery(Object obj, String param){
        Query query = new Query();
        Criteria criteria;
        String methodName = "get" + commonUtils.firstChToUpperCase(param);
        Method m = commonUtils.findMethodByName(obj,methodName);
        try{
            m.invoke(obj);
            criteria = Criteria.where(commonUtils.firstChToLowerCase(param)).gt(m.invoke(obj));
            query.addCriteria(criteria);
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (IllegalAccessException e1){
            e1.printStackTrace();
        }
        return query;
    }


}
