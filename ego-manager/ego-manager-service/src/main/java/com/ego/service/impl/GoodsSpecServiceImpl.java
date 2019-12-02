package com.ego.service.impl;

import com.ego.mapper.GoodsSpecMapper;
import com.ego.pojo.GoodsSpec;
import com.ego.pojo.GoodsSpecExample;
import com.ego.pojo.GoodsTypeExample;
import com.ego.result.BaseResult;
import com.ego.service.GoodsSpecServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品规格service
 * Created by James on 2019/4/7 0007.
 */
@Service
public class GoodsSpecServiceImpl implements GoodsSpecServiceI{

    @Autowired
    GoodsSpecMapper goodsSpecMapper;

    //商品规格--新增保存
    @Override
    public BaseResult goodsSpecSave(GoodsSpec goodsSpec) {
        int result = goodsSpecMapper.insertSelective(goodsSpec);
        return result>0?BaseResult.success():BaseResult.error();
    }

    //商品规格--更新保存
    @Override
    public BaseResult goodsSpecUpdate(GoodsSpec goodsSpec) {
        int result = goodsSpecMapper.updateByPrimaryKey(goodsSpec);
        return result>0?BaseResult.success():BaseResult.error();
    }

    //商品规格--根据主键查询(用户更新信息返显)
    @Override
    public GoodsSpec selectGoodsSpecById(Integer specId) {
        return goodsSpecMapper.selectByPrimaryKey(specId);
    }

    //商品规格--删除
    @Override
    public BaseResult deleteGoodsSpecById(Integer specId) {
        int result = goodsSpecMapper.deleteByPrimaryKey(specId);
        return result>0?BaseResult.success():BaseResult.error();
    }

    //查询所有商品规格列表
    @Override
    public List<GoodsSpec> selectGoodsTypeList() {
        return goodsSpecMapper.selectByExample(new GoodsSpecExample());
    }

    //根据模型(类型)id 查询所有规格
    @Override
    public List<GoodsSpec> selectGoodsByTypeId(Short typeId) {
        GoodsSpecExample goodsSpecExample = new GoodsSpecExample();
        goodsSpecExample.createCriteria().andTypeIdEqualTo(typeId);
        return goodsSpecMapper.selectByExample(goodsSpecExample);
    }
}
