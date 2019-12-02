package com.ego.service;

import com.ego.pojo.Goods;
import com.ego.result.BaseResult;

/**
 * 商品service
 * Created by James on 2019/4/6 0006.
 */
public interface GoodsServiceI {


    /**
     * 分页查询所有商品列表
     * @param goods        商品信息
     * @param pageNum   每页显示条数
     * @param pageSize      总页数
     * @return
     */
    BaseResult selectGoodsList(Goods goods,Integer pageNum,Integer pageSize);

    /**
     *  保存商品
     * @param goods 商品对象
     * @return
     */
    BaseResult goodsSave(Goods goods);
}
