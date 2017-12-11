package com.yxh.onlineStore.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by 杨旭晖 on 2017/12/11.
 */
@Document(collection = "sku")
public class Sku {

    @Id
    private String _id;

    private String prodId;

    private String name;

    private List<SkuValue> values;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkuValue> getValues() {
        return values;
    }

    public void setValues(List<SkuValue> values) {
        this.values = values;
    }

    public Sku(){}

    public Sku(String _id){
        this._id = _id;
    }

    public Sku(String prodId, String name, List<SkuValue> values){
        this.prodId = prodId;
        this.name = name;
        this.values = values;
    }

    public Sku(String _id,String prodId,String name,List<SkuValue> values){
        this._id = _id;
        this.prodId = prodId;
        this.name = name;
        this.values = values;
    }

}
