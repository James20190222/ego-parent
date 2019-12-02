package com.ego.serviceTest;

import com.ego.vo.GoodsCategoryVo;
import com.ego.result.BaseResult;
import com.ego.service.GoodsCategoryServiceI;
import com.ego.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by James on 2019/3/29 0029.
 */

/*
* @RunWith 就是一个运行器
* @RunWith(JUnit4.class)就是指用 JUnit4 来运行
* @RunWith(SpringJUnit4ClassRunner.class)，让测试运行于 Spring 测试环境
*/
@RunWith(SpringJUnit4ClassRunner.class)
/*
* @ContextConfiguration Spring 整合 JUnit4 测试时，使用注解引入多个配置文件
* 单个文件 @ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
* 多个文件 @ContextConfiguration(locations = {"classpath:spring/spring1.xml",
"classpath:mybatis/config.xml"})
*/
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class GoodsCategoryServiceITest {

    @Autowired
    private GoodsCategoryServiceI goodsCategoryService;

    @Test
    public void testSelectCategoryList(){
        List<GoodsCategoryVo> list = goodsCategoryService.selectCategoryListFroViewNormal();
        System.out.println(JsonUtil.object2JsonStr(list));
    }

    @Test
    public void testDeleteBatch(){
        BaseResult baseResult = goodsCategoryService.categoryBatchDelete(new Short[]{860, 861, 862});
        System.out.println(baseResult.getCode());
    }

}
