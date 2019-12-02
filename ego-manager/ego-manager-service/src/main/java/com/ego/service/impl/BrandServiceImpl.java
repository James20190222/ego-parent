package com.ego.service.impl;

import com.ego.mapper.BrandMapper;
import com.ego.pojo.Brand;
import com.ego.pojo.BrandExample;
import com.ego.service.BrandServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by James on 2019/4/1 0001.
 */
@Service
public class BrandServiceImpl implements BrandServiceI {

    @Autowired
    BrandMapper brandMapper;

    //查询品牌分类
    @Override
    public List<Brand> selectBrandList() {
        return brandMapper.selectByExample(new BrandExample());
    }

}
