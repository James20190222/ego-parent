package com.ego.service;

import com.ego.util.JsonUtil;
import com.ego.vo.GoodsCategoryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhong on 2019/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class GoodsCategoryServiceITest {

    @Autowired
    private GoodsCategoryServiceI goodsCategoryService;

    @Test
    public void testSelectGoodsCategoryList() throws IOException {
        System.out.println("方法进来没有???????");
        List<GoodsCategoryVo> list = goodsCategoryService.selectCategoryListFroViewNormal();
        System.out.println("Test++++"+list.size());
        System.out.println(JsonUtil.object2JsonStr(list));

        System.in.read();

    }


}
