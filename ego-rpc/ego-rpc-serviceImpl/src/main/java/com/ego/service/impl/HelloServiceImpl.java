package com.ego.service.impl;

import com.ego.service.HelloServiceI;

public class HelloServiceImpl implements HelloServiceI {

    @Override
    public String sayHello() {
        System.out.println("HelloServiceImpl");
        return "success";
    }

} 