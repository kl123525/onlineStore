package com.yxh.onlineStore.dao.Impl;

import com.yxh.onlineStore.dao.SkuDao;
import com.yxh.onlineStore.dao.support.AbstractBaseMongoTemplete;
import com.yxh.onlineStore.po.Sku;
import com.yxh.onlineStore.utils.MongoUtils;
import com.yxh.onlineStore.utils.MyException;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.List;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
public class SkuDaoImpl extends AbstractBaseMongoTemplete implements SkuDao {

    private MongoUtils mongoUtils = new MongoUtils();

    /**
     * 插入文档
     * @param sku Sku
     * */
    public void insert(Sku sku) {
        mongoTemplate.insert(sku);
    }

    /**
     * 根据ObjectId删除文档
     * @param _id ObjectId
     * */
    public void deleteById(String _id) {
        Sku sku = new Sku(_id);
        mongoTemplate.remove(sku);
    }

    /**
     * 根据条件删除文档
     * @param criteriaSku pojo
     * @param params 条件参数名数组
     * */
    public void deleteBySelect(Sku criteriaSku,String[] params) {
        Query query = mongoUtils.getQuery(criteriaSku,params);
        mongoTemplate.remove(query,Sku.class);
    }

    /**
     * 根据主键更新文档
     * @param sku pojo
     * */
    public void updateById(Sku sku) throws MyException {
        if (sku.get_id() == null){
            throw new MyException("此方法需要包含主键_id");
        }
        Query query = mongoUtils.getQuery(sku,"_id");
        Update update = Update.update("name",sku.getName()).set("values",sku.getValues());
        mongoTemplate.updateFirst(query,update,Sku.class);
    }

    /**
     *根据ObjectId查询sku
     * @param _id ObjectId
     * @return sku
     * */
    public Sku findById(String _id) {
        return mongoTemplate.findById(_id, Sku.class);
    }

    /**
     * 根据prodId查询指定商品所有sku
     * @param prodId 商品id
     * @return list<sku>
     * */
    public List<Sku> findByProdId(String prodId) {
        Criteria criteria;
        criteria = Criteria.where("prodId").gt(Sku.class);
        Query query = new Query(criteria);
        return mongoTemplate.find(query,Sku.class);
    }
}
