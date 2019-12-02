package com.ego.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhong on 2019/4/18.
 */

public class GoodsVo implements Serializable{

    /*
       属性的名称一定要和索引库的名称一致
     */
    /**      * 所有属性名称必须和 ES
     的索引库中的字段名称一致
     */

    private Integer goodsId;


    private String  goodsName;


    private BigDecimal marketPrice;


    private Integer goodsNum;

    private Date addTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", marketPrice=" + marketPrice +
                ", goodsNum=" + goodsNum +
                ", addTime=" + addTime +
                '}';
    }
}
