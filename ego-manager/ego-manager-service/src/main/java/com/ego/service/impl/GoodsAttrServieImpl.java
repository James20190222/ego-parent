package com.ego.service.impl;

import com.ego.mapper.GoodsAttrMapper;
import com.ego.pojo.GoodsAttr;
import com.ego.pojo.GoodsAttrWithBLOBs;
import com.ego.result.BaseResult;
import com.ego.service.GoodsAttrServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 新增商品--商品模型service
 * Created by zhong on 2019/4/10.
 */
@Service
public class GoodsAttrServieImpl implements GoodsAttrServiceI {
    
    @Autowired
    GoodsAttrMapper goodsAttrMapper;


    /**
     *  根据主键查询商品模型(类型)
     * @param goodsAttrId
     * @return
     */
    @Override
    public GoodsAttrWithBLOBs goodsAttrById(Integer goodsAttrId) {
        return goodsAttrMapper.selectByPrimaryKey(goodsAttrId);
    }


    /**
     *  新增--保存
     * @param goodsAttrWithBLOBs
     * @return
     */
    @Override
    public BaseResult goodsAttrSave(GoodsAttrWithBLOBs goodsAttrWithBLOBs) {
        int result = goodsAttrMapper.insertSelective(goodsAttrWithBLOBs);
        if(result>0){
            BaseResult baseResult=BaseResult.success();
            baseResult.setMessage(String.valueOf(goodsAttrWithBLOBs.getGoodsAttrId()));
            return baseResult;
        }
        return BaseResult.error();
    }

    /**
     *  修改--保存
     * @param goodsAttrWithBLOBs
     * @return
     */
    @Override
    public BaseResult goodsAttrUpdate(GoodsAttrWithBLOBs goodsAttrWithBLOBs) {
        int result = goodsAttrMapper.updateByPrimaryKeyWithBLOBs(goodsAttrWithBLOBs);
        if(result>0){
            BaseResult baseResult=BaseResult.success();
            baseResult.setMessage(String.valueOf(goodsAttrWithBLOBs.getGoodsAttrId()));
            return baseResult;
        }
        return BaseResult.error();
    }
}
