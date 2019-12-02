package com.ego.service;

import com.ego.pojo.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by James on 2019/4/1 0001.
 */
public interface BrandServiceI {

    //查询所有商品品牌
    List<Brand> selectBrandList();
}
