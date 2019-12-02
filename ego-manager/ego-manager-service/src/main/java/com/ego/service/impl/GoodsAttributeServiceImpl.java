package com.ego.service.impl;

import com.ego.mapper.GoodsAttributeMapper;
import com.ego.pojo.GoodsAttribute;
import com.ego.pojo.GoodsAttributeExample;
import com.ego.result.BaseResult;
import com.ego.service.GoodsAttributeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性service
 * Created by James on 2019/4/8 0008.
 */
@Service
public class GoodsAttributeServiceImpl implements GoodsAttributeServiceI {


    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;

    //商品属性--新增保存
    @Override
    public BaseResult goodsAttributeSave(GoodsAttribute goodsAttribute) {
        int result = goodsAttributeMapper.insertSelective(goodsAttribute);
        return result>0 ? BaseResult.success():BaseResult.error();
    }

    //商品属性--更新保存
    @Override
    public BaseResult goodsAttributeUpdate(GoodsAttribute goodsAttribute) {
        int result = goodsAttributeMapper.updateByPrimaryKey(goodsAttribute);
        return result>0 ? BaseResult.success():BaseResult.error();
    }

    //商品属性--删除
    @Override
    public BaseResult goodsAttributeDelete(Integer attrId) {
        int result = goodsAttributeMapper.deleteByPrimaryKey(attrId);
        return result>0 ? BaseResult.success():BaseResult.error();
    }

    //商品属性--所有列表查询
    @Override
    public List<GoodsAttribute> selectGoodsAttributeList() {
        return goodsAttributeMapper.selectByExample(new GoodsAttributeExample());
    }

    //商品属性--根据主键查询(用于更新返显信息)
    @Override
    public GoodsAttribute selectGoodsAttributeByAttrId(Integer attrId) {
        return goodsAttributeMapper.selectByPrimaryKey(attrId);
    }

    //商品属性列表--根据模型(类型)id查询(用于页面筛选查询)
    @Override
    public List<GoodsAttribute> selectGoodsAttributeListByTypeId(Short typeId) {
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        goodsAttributeExample.createCriteria().andTypeIdEqualTo(typeId);
        return goodsAttributeMapper.selectByExample(goodsAttributeExample);
    }
}
