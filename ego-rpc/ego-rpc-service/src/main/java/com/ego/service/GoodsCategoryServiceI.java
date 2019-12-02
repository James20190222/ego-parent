package com.ego.service;

import com.ego.vo.GoodsCategoryVo;

import java.util.List;

/**
 * 商品分类服务
 * Created by zhong on 2019/4/15.
 */
public interface GoodsCategoryServiceI {

    /**
     * 商品分类-查询所有商品分类
     *
     * @return
     */
    List<GoodsCategoryVo> selectCategoryListFroViewNormal();
}
