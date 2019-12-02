package com.ego.service.impl;

import com.ego.result.EgoPageInfo;
import com.ego.service.SearchServiceI;
import com.ego.vo.GoodsVo;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 2019/4/18.
 */
@Service
public class SearchServiceImpl implements SearchServiceI {


    /*@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private GoodsResult goodsResult;*/

    @Autowired
    private TransportClient client;

    /**
     *  商品搜索服务
     * @param searchStr
     * @param pageNum
     * @param pageSize
     * @return
     */
   /* @Override
    public Page<GoodsVo> doSearch(String searchStr, Integer pageNum, Integer pageSize) {
        HighlightBuilder.Field field = new HighlightBuilder.Field("goodsName")
                .preTags("<font style='color:red;'>")
                .postTags("</font>");
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("goodsName", searchStr))
                .withPageable(new PageRequest(pageNum-1, pageSize))
                .withHighlightFields(field)
                .build();

        return elasticsearchTemplate.queryForPage(searchQuery, GoodsVo.class, goodsResult);
    }*/


    /**
     * 商品搜索服务
     *
     * @param searchStr
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public EgoPageInfo<GoodsVo> doSearch(String searchStr, Integer pageNum, Integer pageSize) {
        // 从ik和ego索引库中搜索ikType和t_goods类型
        SearchRequestBuilder builder = client.prepareSearch("ego").setTypes("goods");
        // 设置分页
        builder.setFrom((pageNum - 1) * pageSize).setSize(pageSize);
        // 设置高亮
        // 前缀
        builder.setHighlighterPreTags("<font style='color:red;'>");
        // 后缀
        builder.setHighlighterPostTags("</font>");
        // 高亮字段
        builder.addHighlightedField("goodsName");
        // 查询所有
        builder.setQuery(QueryBuilders.multiMatchQuery(searchStr, "goodsName"));
        // 开始查询
        SearchResponse response = builder.get();
        // 获取命中数据
        SearchHits hits = response.getHits();
        // 循环获取数据
        List<GoodsVo> goodsVoList = new ArrayList();
        for (SearchHit searchHit : hits) {
            // 查询高亮数据
            String highLightMessage = searchHit.getHighlightFields().get("goodsName").fragments()[0].toString();
            // 初始化高亮对象
            GoodsVo goodsVo = new GoodsVo();
            goodsVo.setGoodsId(Integer.parseInt(searchHit.getId()));
            goodsVo.setGoodsName(String.valueOf(searchHit.getSource().get("goodsName")));
            goodsVo.setGoodsHlName(highLightMessage);
            goodsVo.setMarketPrice(new BigDecimal(String.valueOf(searchHit.getSource().get("marketPrice"))));
            goodsVo.setOriginalImg(String.valueOf(searchHit.getSource().get("originalImg")));
            // 添加至集合
            goodsVoList.add(goodsVo);
        }

        // 构建分页对象
        Long total = hits.getTotalHits();
        EgoPageInfo<GoodsVo> pageInfo = new EgoPageInfo<>(pageNum, pageSize, total.intValue());
        pageInfo.setResult(goodsVoList);
        return pageInfo;
    }




}
