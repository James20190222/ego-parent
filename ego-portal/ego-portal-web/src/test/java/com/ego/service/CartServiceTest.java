package com.ego.service;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.vo.GoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *  购物车服务测试
 * Created by zhong on 2019/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class CartServiceTest {
    @Autowired
    private CartServiceI cartService;

    @Test
    public void testAddToCart(){
        GoodsVo goodsVo =new GoodsVo();
        goodsVo.setGoodsId(12345);
        goodsVo.setGoodsName("测试商品");
        goodsVo.setGoodsNum(1);

        Admin admin = new Admin();
        admin.setAdminId((short)2222);
        admin.setUserName("李四");

        BaseResult result = cartService.addToCart(admin, goodsVo);
        System.out.println("测试Result:"+result.getCode());
    }

    @Test
    public void testCartNum(){
        Admin admin=new Admin();
        admin.setAdminId((short)1111);
        Integer cartNum = cartService.getCartNum(admin);
        System.out.println("购物车商品数量:"+cartNum);
    }


}
