package com.ego.service.impl;

import com.ego.mapper.GoodsCategoryMapper;
import com.ego.pojo.GoodsCategory;
import com.ego.pojo.GoodsCategoryExample;
import com.ego.util.JsonUtil;
import com.ego.vo.GoodsCategoryVo;
import com.ego.result.BaseResult;
import com.ego.service.GoodsCategoryServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2019/3/28 0028.
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryServiceI {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //商品分类--编辑保存
    @Override
    public BaseResult categoryUpdate(GoodsCategory goodsCategory) {
        int result = goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory);
        //保存成功,清楚原有缓存
        if(result>0){
            redisTemplate.delete(redisTemplate.keys("goodsCategoryList:*"));
            return BaseResult.success();
        }
        return  BaseResult.error();
    }

    //商品分类---删除(根据主键id 删除)
    @Override
    public BaseResult categoryDelete(Short id) {
        int result = goodsCategoryMapper.deleteByPrimaryKey(id);
        //保存成功,清楚原有缓存
        if(result>0){
            redisTemplate.delete(redisTemplate.keys("goodsCategoryList:*"));
            return BaseResult.success();
        }
        return  BaseResult.error();
    }

    //商品分类--批量删除
    @Override
    public BaseResult categoryBatchDelete(Short[] ids) {
        int result = goodsCategoryMapper.deleteBatchByPrimaryKeys(ids);
        //保存成功,清楚原有缓存
        if(result==ids.length){
            redisTemplate.delete(redisTemplate.keys("goodsCategoryList:*"));
            return BaseResult.success();
        }
        return  BaseResult.error();
    }

    /*查询所有商品分类*/
    @Override
    public List<GoodsCategoryVo> selectCategoryListFroViewNormal() {

        //创建查询对象
        GoodsCategoryExample example=new GoodsCategoryExample();
        //设置查询条件
        example.createCriteria().andParentIdEqualTo((short)0).andLevelEqualTo((byte)1);
        //一级查询
        List<GoodsCategory> gcList1 = null;
        //查询一级缓存
        String goodsCategoryListLevel1="goodsCategoryList:Level_1";
        String Level_1_Str = redisTemplate.opsForValue().get(goodsCategoryListLevel1);
        if(null!=Level_1_Str && Level_1_Str.length()>0){
            gcList1= JsonUtil.jsonToList(Level_1_Str, GoodsCategory.class);
        }else{
            gcList1=goodsCategoryMapper.selectByExample(example);
            //添加一级缓存
            String jsonStr = JsonUtil.object2JsonStr(gcList1);
            redisTemplate.opsForValue().set("goodsCategoryList:Level_1",jsonStr);
        }

        //创建一级分类VO对象
        List<GoodsCategoryVo> gcvList1=new ArrayList<>();
        for(int i=0;i<gcList1.size();i++){
            //创建vo对象
            GoodsCategoryVo gcv1=new GoodsCategoryVo();
            //复制属性
            BeanUtils.copyProperties(gcList1.get(i),gcv1);
            //清除查询参数
            example.clear();
            //查询二级分类
            example.createCriteria().andParentIdEqualTo(gcList1.get(i).getId()).andLevelEqualTo((byte)2);
            List<GoodsCategory> gcList2 = null;
            //查询二级分类缓存
            String goodsCategoryListLevel2="goodsCategoryList:Level_2"+"_"+i;
            String Level_2_Str = redisTemplate.opsForValue().get(goodsCategoryListLevel2);
            if(null!=Level_2_Str && Level_2_Str.length()>0){
                gcList2=JsonUtil.jsonToList(Level_2_Str,GoodsCategory.class);
            }
                gcList2=goodsCategoryMapper.selectByExample(example);
            //添加二级缓存
            String jsonStr2 = JsonUtil.object2JsonStr(gcList2);
            redisTemplate.opsForValue().set("goodsCategoryList:Level_2"+"_"+i,jsonStr2);
            //创建二级分类VO对象
            List<GoodsCategoryVo> gcvList2=new ArrayList<>();
            for(int j=0;j<gcList2.size();j++){
                //创建vo对象
                GoodsCategoryVo gcv2=new GoodsCategoryVo();
                //复制属性
                BeanUtils.copyProperties(gcList2.get(j),gcv2);
                //清除查询参数
                example.clear();
                //查询三级分类
                example.createCriteria().andParentIdEqualTo(gcList2.get(j).getId()).andLevelEqualTo((byte)3);
                List<GoodsCategory> gcList3 = null;
                //查询三级缓存分类
                String goodsCategoryListLevel3="goodsCategoryList:Level_3"+"_"+j;
                String Level_3_Str = redisTemplate.opsForValue().get(goodsCategoryListLevel3);
                if(null!=Level_3_Str && Level_3_Str.length()>0){
                    gcList3=JsonUtil.jsonToList(Level_3_Str,GoodsCategory.class);
                }
                gcList3=goodsCategoryMapper.selectByExample(example);
                //添加三级缓存
                String jsonStr3 = JsonUtil.object2JsonStr(gcList3);
                redisTemplate.opsForValue().set("goodsCategoryList:Level_3"+"_"+j,jsonStr3);

                //创建三级分类VO对象
                List<GoodsCategoryVo> gcvList3=new ArrayList<>();
                for(int k=0;k<gcList3.size();k++){
                    //创建vo对象
                    GoodsCategoryVo gcv3=new GoodsCategoryVo();
                    //复制属性
                    BeanUtils.copyProperties(gcList3.get(k),gcv3);
                    //添加至三级vo集合
                    gcvList3.add(gcv3);
                }
                //将三级分类添加至二级分类
                gcv2.setChildren(gcvList3);
                gcvList2.add(gcv2);
            }
            //将二级分类添加至一级分类
            gcv1.setChildren(gcvList2);
            gcvList1.add(gcv1);
        }

        return gcvList1;
    }

    //查询所有分类,给商品列表使用
    @Override
    public List<GoodsCategory> selectCateListForGoodsList() {
        return goodsCategoryMapper.selectByExample(new GoodsCategoryExample());
    }


    //保存新增商品信息
    @Override
    public BaseResult categorySave(GoodsCategory goodsCategory) {
        int result=goodsCategoryMapper.insertSelective(goodsCategory);
        //保存成功,清除原有缓存
        if(result>0){
            redisTemplate.delete(redisTemplate.keys("goodsCategoryList:*"));
            return BaseResult.success();
        }
        return  BaseResult.error();
    }

    //商品分类-新增分类- 查询顶级分类(一级)
    @Override
    public List<GoodsCategory> selectTopCategory() {

        //创建查询对象
        GoodsCategoryExample example=new GoodsCategoryExample();

        //查询条件
        example.createCriteria().andParentIdEqualTo((short)0);

        List<GoodsCategory> list = goodsCategoryMapper.selectByExample(example);
        //执行查询
        return (null!=list && !list.isEmpty())?list:null;
    }

   //商品分类-新增分类-查询商品分类(二级)
    @Override
    public List<GoodsCategory> selectCategoryGetByParentId(short parentId) {
        //创建查询对象
        GoodsCategoryExample example=new GoodsCategoryExample();

        //查询条件
        example.createCriteria().andParentIdEqualTo(parentId);

        List<GoodsCategory> list = goodsCategoryMapper.selectByExample(example);

        return (null!=list && !list.isEmpty())?list:null;
    }

    //根据主键查询分类
    @Override
    public GoodsCategory selectCategoryById(Short id) {
        return goodsCategoryMapper.selectByPrimaryKey(id);
    }
}
