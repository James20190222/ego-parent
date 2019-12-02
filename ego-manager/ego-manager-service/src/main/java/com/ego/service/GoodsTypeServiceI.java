package com.ego.service;

import com.ego.pojo.GoodsType;
import com.ego.result.BaseResult;

import java.util.List;

/**
 * Created by James on 2019/4/7 0007.
 */

//商品模型service
public interface GoodsTypeServiceI {

    //商品模型新增保存
     BaseResult goodsTypeSave(GoodsType goodsType);

     //商品模型修改
    BaseResult goodsTypeUpdate(GoodsType goodsType);

    //商品模型删除
    BaseResult goodsTypeDelete(Short id);

    //商品模型列表
    List<GoodsType> selectGoodsTypeList();

    //根据主键查商品模型
    GoodsType selectGoodsTypeById(Short id);
}
