package com.ego.mapper;

import com.ego.pojo.GoodsAttr;
import com.ego.pojo.GoodsAttrExample;
import com.ego.pojo.GoodsAttrWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsAttrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    long countByExample(GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int deleteByExample(GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int deleteByPrimaryKey(Integer goodsAttrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int insert(GoodsAttrWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int insertSelective(GoodsAttrWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    List<GoodsAttrWithBLOBs> selectByExampleWithBLOBs(GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    List<GoodsAttr> selectByExample(GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    GoodsAttrWithBLOBs selectByPrimaryKey(Integer goodsAttrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int updateByExampleSelective(@Param("record") GoodsAttrWithBLOBs record, @Param("example") GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") GoodsAttrWithBLOBs record, @Param("example") GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int updateByExample(@Param("record") GoodsAttr record, @Param("example") GoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int updateByPrimaryKeySelective(GoodsAttrWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(GoodsAttrWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_attr
     *
     * @mbg.generated Tue Apr 09 13:12:05 CST 2019
     */
    int updateByPrimaryKey(GoodsAttr record);
}