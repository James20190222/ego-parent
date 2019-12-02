package com.ego.mapper;

import com.ego.pojo.OrderGoods;
import com.ego.pojo.OrderGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    long countByExample(OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int deleteByExample(OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int deleteByPrimaryKey(Integer recId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int insert(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int insertSelective(OrderGoods record);

    /**
     * 批量插入的方法
     * @param orderGoodsList
     * @return
     */
    int insertBatchSelective(List<OrderGoods> orderGoodsList);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    List<OrderGoods> selectByExample(OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    OrderGoods selectByPrimaryKey(Integer recId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int updateByPrimaryKeySelective(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_goods
     *
     * @mbg.generated Sun Apr 21 17:44:08 CST 2019
     */
    int updateByPrimaryKey(OrderGoods record);
}