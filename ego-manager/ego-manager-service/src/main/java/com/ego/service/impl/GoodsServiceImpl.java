package com.ego.service.impl;

import com.ego.mapper.GoodsMapper;
import com.ego.pojo.Goods;
import com.ego.pojo.GoodsExample;
import com.ego.result.BaseResult;
import com.ego.service.GoodsServiceI;
import com.ego.util.JsonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by James on 2019/4/6 0006.
 */
@Service
public class GoodsServiceImpl implements GoodsServiceI {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 分页查询所有商品列表
     * @param goods         商品信息
     * @param pageNum   每页显示条数
     * @param pageSize      总页数
     * @return
     */
    @Override
    public BaseResult selectGoodsList(Goods goods,Integer pageNum,Integer pageSize) {
        //创建example对象
        GoodsExample example = new GoodsExample();
        //创建查询对象
        GoodsExample.Criteria criteria = example.createCriteria();
        //构建分页对象
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, pageSize);

        String []goodsArrKeys={"goods:pageNum_"+pageNum+":pageSize_"+pageSize,
                            ":catId_",
                            ":brandId_",
                            ":goodsName_"};

        //处理查询参数
        if(null!=goods.getCatId()){
            criteria.andCatIdEqualTo(goods.getCatId());
            goodsArrKeys[1]=":catId_"+goods.getCatId();
        }
        if(null!=goods.getBrandId()){
            criteria.andBrandIdEqualTo(goods.getBrandId());
            goodsArrKeys[1]=":brandId_"+goods.getBrandId();
        }
        if(null!=goods.getGoodsName() && goods.getGoodsName().trim().length()>0){
            criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
            goodsArrKeys[1]=":goodsName_"+goods.getGoodsName();
        }

        //将数组转为字符串
        String goodsKey="";
        for(int i=0;i<goodsArrKeys.length;i++){
            goodsKey+=goodsArrKeys[i];
        }
        //查询
        PageInfo<Goods> pageInfo=null;
        //先查询redis
        String pageInfoStr=redisTemplate.opsForValue().get(goodsKey);
        //判断缓存是否有数据
        if(null!=pageInfoStr && pageInfoStr.length()>0){
            pageInfo = JsonUtil.jsonStr2Object(pageInfoStr,PageInfo.class);
            BaseResult result= BaseResult.success(pageInfo);
            return result;
        }
        //如果没有,查询关系数据库并写入缓存数据库
        List<Goods> list = goodsMapper.selectByExample(example);
        if(null!=list && !list.isEmpty()){
            pageInfo = new PageInfo<>(list);
            //写入缓存数据库
            redisTemplate.opsForValue().set(goodsKey,JsonUtil.object2JsonStr(pageInfo));
            BaseResult result= BaseResult.success(pageInfo);
            return result;
        }
        return BaseResult.error();
    }

    //保存商品
    @Override
    public BaseResult goodsSave(Goods goods) {
        // 保存对象时处理需要转义的属性
        if(goods.getGoodsContent() != null && goods.getGoodsContent().length() > 0) {
            String htmlEscape = HtmlUtils.htmlEscape(goods.getGoodsContent(), "UTF-8");
            goods.setGoodsContent(htmlEscape);
        }
        int result = goodsMapper.insertSelective(goods);
        if(result>0){
            //清除redis缓存
            Set<String> keys = redisTemplate.keys("goods:*");
            redisTemplate.delete(keys);
            BaseResult baseResult = BaseResult.success();
            baseResult.setMessage(String.valueOf(goods.getGoodsId()));
            return baseResult;
        }
        return BaseResult.error();
    }
}
