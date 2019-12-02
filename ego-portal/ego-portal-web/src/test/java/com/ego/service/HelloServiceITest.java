package com.ego.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by zhong on 2019/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class HelloServiceITest {
    @Autowired
    private HelloServiceI helloService;

    @Test
    public void testSayHello() throws IOException {

        String result = helloService.sayHello();
        System.out.println("结果："+result);
        System.in.read();
    }
}
