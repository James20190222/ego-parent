package com.ego.pojo;

import java.io.Serializable;

public class GoodsAttr implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_attr.goods_attr_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    private Integer goodsAttrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_attr.goods_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_attr.attr_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    private Integer attrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_attr.spec_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    private Integer specId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_attr.attr_price
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    private String attrPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_attr.goods_attr_id
     *
     * @return the value of t_goods_attr.goods_attr_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public Integer getGoodsAttrId() {
        return goodsAttrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_attr.goods_attr_id
     *
     * @param goodsAttrId the value for t_goods_attr.goods_attr_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public void setGoodsAttrId(Integer goodsAttrId) {
        this.goodsAttrId = goodsAttrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_attr.goods_id
     *
     * @return the value of t_goods_attr.goods_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_attr.goods_id
     *
     * @param goodsId the value for t_goods_attr.goods_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_attr.attr_id
     *
     * @return the value of t_goods_attr.attr_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public Integer getAttrId() {
        return attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_attr.attr_id
     *
     * @param attrId the value for t_goods_attr.attr_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_attr.spec_id
     *
     * @return the value of t_goods_attr.spec_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_attr.spec_id
     *
     * @param specId the value for t_goods_attr.spec_id
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_attr.attr_price
     *
     * @return the value of t_goods_attr.attr_price
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public String getAttrPrice() {
        return attrPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_attr.attr_price
     *
     * @param attrPrice the value for t_goods_attr.attr_price
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    public void setAttrPrice(String attrPrice) {
        this.attrPrice = attrPrice == null ? null : attrPrice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsAttrId=").append(goodsAttrId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", attrId=").append(attrId);
        sb.append(", specId=").append(specId);
        sb.append(", attrPrice=").append(attrPrice);
        sb.append("]");
        return sb.toString();
    }
}