package com.ego.repository;

import com.ego.vo.GoodsVo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by zhong on 2019/4/18.
 */
public interface GoodsRepository extends ElasticsearchRepository<GoodsVo,Integer>,Repository<GoodsVo,Integer> {//ElasticsearchReposity默认自带一些方法
    GoodsVo findOne(Integer primaryKey);
    Iterable<GoodsVo> findAll();
    Long countByGoodsName(String goodsName);
    List<GoodsVo> findByGoodsName(String goodsName);
}
