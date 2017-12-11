package com.yxh.onlineStore.dao;

import com.yxh.onlineStore.po.Sku;
import com.yxh.onlineStore.utils.MyException;

import java.util.List;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
public interface SkuDao {

    /**
     * 新增sku
     * @param sku
     * sku信息
     * */
    void insert(Sku sku);

    /**
     * 根据ObjectId删除
     * @param _id ObjectId
     * */
    void deleteById(String _id);

    /**
     * 根据条件删除
     * @param skuCriteria sku实例
     * @param params 条件参数名
     * */
    void deleteBySelect(Sku skuCriteria,String params[]);

    /**
     * 根据ObjectId更新文档
     * @param sku Sku
     * */
    void updateById(Sku sku) throws MyException;

    /**
     * 根据ObjectId找出单个sku
     * @param id ObjectId
     * @return sku
     * */
    Sku findById(String id);

    /**
     * 查询指定产品所有sku
     * @param prodId 产品id
     * @return List<Sku>
     * */
    List<Sku> findByProdId(String prodId);

}
