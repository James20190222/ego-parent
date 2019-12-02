package com.ego.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by James on 2019/4/9 0009.
 */
@Component
@RequestMapping("/user")
public class UserController {

    /**
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){

        return "redirect:"
                +request.getSession().getServletContext().getAttribute("portalUrl")
                +"user/logout";
    }

}
