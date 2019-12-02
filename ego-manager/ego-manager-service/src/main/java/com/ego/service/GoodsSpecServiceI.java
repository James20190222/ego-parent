package com.ego.service;

import com.ego.pojo.GoodsSpec;
import com.ego.result.BaseResult;

import java.util.List;

/**
 * 商品规格service
 * Created by James on 2019/4/7 0007.
 */
public interface GoodsSpecServiceI {

    //商品规格--新增保存
    BaseResult goodsSpecSave(GoodsSpec goodsSpec);

    //商品规格--修改保存
    BaseResult goodsSpecUpdate(GoodsSpec goodsSpec);

    //商品规格--根据主键查询(用于修改页面返显)
    GoodsSpec selectGoodsSpecById(Integer specId);

    //商品规格--根据主键删除
    BaseResult deleteGoodsSpecById(Integer specId);

    //商品规格--列表查询
    List<GoodsSpec> selectGoodsTypeList();

    //根据模型(类型)Id 查询所有规格
    List<GoodsSpec> selectGoodsByTypeId(Short typeId);
}
