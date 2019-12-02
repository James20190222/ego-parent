package com.ego.service;

import com.ego.result.EgoPageInfo;
import com.ego.vo.GoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhong on 2019/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class SearchServiceTest {
    @Autowired
    private SearchServiceI searchService;

    @Test
    public void testDoSearch(){
       /* Page<GoodsVo> page = searchService.doSearch("中国移动联通电信", 1, 20);
        System.out.println(page.getTotalElements());*/
        EgoPageInfo<GoodsVo> page = searchService.doSearch("中国移动联通电信", 1, 20);
        System.out.println(page.getResult());
    }

}
