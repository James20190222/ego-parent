package com.ego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by James on 2019/3/25 0025.
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        System.out.println("pageController-----------------"+page);
        return page;
    }

}
