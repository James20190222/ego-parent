package com.ego.service;

import com.ego.pojo.GoodsAttribute;
import com.ego.result.BaseResult;

import java.util.List;

/**
 * 商品属性service
 * Created by James on 2019/4/8 0008.
 */
public interface GoodsAttributeServiceI {
    //商品属性添加
    BaseResult goodsAttributeSave(GoodsAttribute goodsAttribute);

    //商品属性更新 保存
    BaseResult goodsAttributeUpdate(GoodsAttribute goodsAttribute);

    //商品属性 删除
    BaseResult goodsAttributeDelete(Integer attrId);

    //商品属性列表
    List<GoodsAttribute> selectGoodsAttributeList();

    //商品属性查询---根据主键
    GoodsAttribute selectGoodsAttributeByAttrId(Integer attrId);

    //商品属性查询--根据模型(类型)id
    List<GoodsAttribute> selectGoodsAttributeListByTypeId(Short typeId);


}
