package com.ego.service;

import com.ego.pojo.GoodsAttr;
import com.ego.pojo.GoodsAttrWithBLOBs;
import com.ego.result.BaseResult;

/**
 * 新增商品--商品模型service
 * Created by zhong on 2019/4/10.
 */
public interface GoodsAttrServiceI {

    //根据主键查询商品模型
    GoodsAttrWithBLOBs goodsAttrById(Integer goodsAttrId);

    /**
     *  新增--保存
     * @param goodsAttrWithBLOBs
     * @return
     */
    BaseResult goodsAttrSave(GoodsAttrWithBLOBs goodsAttrWithBLOBs);

    /**
     *  修改--保存
     * @param goodsAttrWithBLOBs
     * @return
     */
    BaseResult goodsAttrUpdate(GoodsAttrWithBLOBs goodsAttrWithBLOBs);
}
