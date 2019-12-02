package com.ego.mapper;

import com.ego.pojo.GoodsSpec;
import com.ego.pojo.GoodsSpecExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSpecMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    long countByExample(GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int deleteByExample(GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     * @param specId
     */
    int deleteByPrimaryKey(Integer specId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int insert(GoodsSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int insertSelective(GoodsSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    List<GoodsSpec> selectByExampleWithBLOBs(GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    List<GoodsSpec> selectByExample(GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     * @param specId
     */
    GoodsSpec selectByPrimaryKey(Integer specId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int updateByExampleSelective(@Param("record") GoodsSpec record, @Param("example") GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") GoodsSpec record, @Param("example") GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int updateByExample(@Param("record") GoodsSpec record, @Param("example") GoodsSpecExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int updateByPrimaryKeySelective(GoodsSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(GoodsSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_spec
     *
     * @mbg.generated Sun Apr 07 13:12:47 CST 2019
     */
    int updateByPrimaryKey(GoodsSpec record);
}