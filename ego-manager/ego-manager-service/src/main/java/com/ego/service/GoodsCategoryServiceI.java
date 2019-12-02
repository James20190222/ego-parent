package com.ego.service;

import com.ego.pojo.GoodsCategory;
import com.ego.vo.GoodsCategoryVo;
import com.ego.result.BaseResult;

import java.util.List;

/**
 * Created by James on 2019/3/28 0028.
 */
public interface GoodsCategoryServiceI {


    //商品分类--编辑保存
    BaseResult categoryUpdate(GoodsCategory goodsCategory);

    //商品分类---删除(根据主键id 删除)
    BaseResult categoryDelete(Short id);

    //商品分类--批量删除
    BaseResult categoryBatchDelete(Short []ids);


    /**
     * 商品分类-查询所有商品分类
     *
     * @return
     */
    List<GoodsCategoryVo> selectCategoryListFroViewNormal();

    //查询所有分类,给商品列表使用
    List<GoodsCategory> selectCateListForGoodsList();


    //商品新增--保存
    BaseResult categorySave(GoodsCategory goodsCategory);

   /*
   *
   *  商品分类-新增分类-查询所有顶级分类
   * */
    List<GoodsCategory> selectTopCategory();

    /*
    *
    *  商品分类-新增分类-根据父ID查询子分类
    * */

    List<GoodsCategory>  selectCategoryGetByParentId(short parentId);


    //根据Id查询商品分类信息
    GoodsCategory selectCategoryById(Short id);

}
