package com.ego.service;

import com.ego.pojo.GoodsImages;
import com.ego.result.BaseResult;

/**
 * 商品相册service
 * Created by James on 2019/4/6 0006.
 */
public interface GoodsImagesServiceI {
    /**
     * 添加商品相册对象
     * @param goodsImages
     * @return
     */
    BaseResult goodsImagesSave(GoodsImages goodsImages);
}
