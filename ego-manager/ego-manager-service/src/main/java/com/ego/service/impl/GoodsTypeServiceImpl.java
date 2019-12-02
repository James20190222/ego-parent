package com.ego.service.impl;

import com.ego.mapper.GoodsTypeMapper;
import com.ego.pojo.GoodsType;
import com.ego.pojo.GoodsTypeExample;
import com.ego.result.BaseResult;
import com.ego.service.GoodsTypeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品模型service
 * Created by James on 2019/4/7 0007.
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeServiceI {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;


    //商品模型---根据主键查询
    @Override
    public GoodsType selectGoodsTypeById(Short id) {
        return goodsTypeMapper.selectByPrimaryKey(id);
    }

    //商品模型--列表
    @Override
    public List<GoodsType> selectGoodsTypeList() {
        return goodsTypeMapper.selectByExample(new GoodsTypeExample());
    }

    //商品模型---删除
    @Override
    public BaseResult goodsTypeDelete(Short id) {
        int result = goodsTypeMapper.deleteByPrimaryKey(id);
        return result>0?BaseResult.success():BaseResult.error();
    }

    //商品模型---修改
    @Override
    public BaseResult goodsTypeUpdate(GoodsType goodsType) {
        int result = goodsTypeMapper.updateByPrimaryKeySelective(goodsType);
        return result>0?BaseResult.success():BaseResult.error();
    }


    //商品模型---新增保存
    @Override
    public BaseResult goodsTypeSave(GoodsType goodsType) {
        int result = goodsTypeMapper.insertSelective(goodsType);
        return result>0?BaseResult.success():BaseResult.error();
    }



}
