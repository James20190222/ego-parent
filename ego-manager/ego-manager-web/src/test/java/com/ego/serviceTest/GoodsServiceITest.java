package com.ego.serviceTest;

import com.ego.pojo.Goods;
import com.ego.service.GoodsServiceI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhong on 2019/4/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class GoodsServiceITest {

    @Autowired
    private GoodsServiceI goodsService;

    @Test
    public void testSelectGoodsList(){
        System.out.println(goodsService.selectGoodsList(new Goods(),1,10));
    }
}
