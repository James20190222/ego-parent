package com.ego.service;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.result.CartResult;
import com.ego.vo.GoodsVo;

import java.util.List;

/**
 *  购物车服务
 * Created by zhong on 2019/4/19.
 */
public interface CartServiceI {

    /**
     * 添加购物车
     */
    BaseResult addToCart(Admin admin,GoodsVo goodsVo);


    /**
     * 查询购物车商品数量
     */
    Integer getCartNum(Admin admin);


    /**
     * 查询购车商品列表
     */
    CartResult getCartList(Admin admin);

    /**
     * 删除购物车单个商品
     */
    BaseResult deleteCart(Admin admin,Integer goodsId);

    /**
     *  清空购物车
     */
    BaseResult clearCart(Admin admin);
}
