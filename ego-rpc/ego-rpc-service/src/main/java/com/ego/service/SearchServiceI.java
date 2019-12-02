package com.ego.service;

import com.ego.result.EgoPageInfo;
import com.ego.vo.GoodsVo;
import org.springframework.data.domain.Page;

/**
 *  商品搜索服务
 * Created by zhong on 2019/4/18.
 */
public interface SearchServiceI {

    /**
     *  根据商品名称搜索商品
     * @param searchStr
     * @param pageNum
     * @param pageSize
     * @return
     */
    /*Page<GoodsVo> doSearch(String searchStr, Integer pageNum, Integer pageSize);*/
    EgoPageInfo<GoodsVo> doSearch(String searchStr, Integer pageNum, Integer pageSize);
}
