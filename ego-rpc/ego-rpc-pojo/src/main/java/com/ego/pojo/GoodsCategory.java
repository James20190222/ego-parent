package com.ego.pojo;

import java.io.Serializable;

public class GoodsCategory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.id
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Short id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.name
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.mobile_name
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private String mobileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.parent_id
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Short parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.parent_id_path
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private String parentIdPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.level
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Byte level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.sort_order
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Byte sortOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.is_show
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Byte isShow;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.image
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.is_hot
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Byte isHot;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.cat_group
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Byte catGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_category.commission_rate
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private Byte commissionRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goods_category
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.id
     *
     * @return the value of t_goods_category.id
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Short getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.id
     *
     * @param id the value for t_goods_category.id
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.name
     *
     * @return the value of t_goods_category.name
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.name
     *
     * @param name the value for t_goods_category.name
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.mobile_name
     *
     * @return the value of t_goods_category.mobile_name
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.mobile_name
     *
     * @param mobileName the value for t_goods_category.mobile_name
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName == null ? null : mobileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.parent_id
     *
     * @return the value of t_goods_category.parent_id
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Short getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.parent_id
     *
     * @param parentId the value for t_goods_category.parent_id
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.parent_id_path
     *
     * @return the value of t_goods_category.parent_id_path
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public String getParentIdPath() {
        return parentIdPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.parent_id_path
     *
     * @param parentIdPath the value for t_goods_category.parent_id_path
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath == null ? null : parentIdPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.level
     *
     * @return the value of t_goods_category.level
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.level
     *
     * @param level the value for t_goods_category.level
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.sort_order
     *
     * @return the value of t_goods_category.sort_order
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Byte getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.sort_order
     *
     * @param sortOrder the value for t_goods_category.sort_order
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.is_show
     *
     * @return the value of t_goods_category.is_show
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Byte getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.is_show
     *
     * @param isShow the value for t_goods_category.is_show
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.image
     *
     * @return the value of t_goods_category.image
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.image
     *
     * @param image the value for t_goods_category.image
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.is_hot
     *
     * @return the value of t_goods_category.is_hot
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.is_hot
     *
     * @param isHot the value for t_goods_category.is_hot
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.cat_group
     *
     * @return the value of t_goods_category.cat_group
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Byte getCatGroup() {
        return catGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.cat_group
     *
     * @param catGroup the value for t_goods_category.cat_group
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setCatGroup(Byte catGroup) {
        this.catGroup = catGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_category.commission_rate
     *
     * @return the value of t_goods_category.commission_rate
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public Byte getCommissionRate() {
        return commissionRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_category.commission_rate
     *
     * @param commissionRate the value for t_goods_category.commission_rate
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    public void setCommissionRate(Byte commissionRate) {
        this.commissionRate = commissionRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_category
     *
     * @mbg.generated Wed Mar 27 15:09:51 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mobileName=").append(mobileName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIdPath=").append(parentIdPath);
        sb.append(", level=").append(level);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isShow=").append(isShow);
        sb.append(", image=").append(image);
        sb.append(", isHot=").append(isHot);
        sb.append(", catGroup=").append(catGroup);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append("]");
        return sb.toString();
    }
}