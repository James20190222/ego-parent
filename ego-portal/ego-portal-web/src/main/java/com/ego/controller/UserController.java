package com.ego.controller;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.service.CookieServiceI;
import com.ego.service.SSOServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by James on 2019/4/9 0009.
 */
@Component
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SSOServiceI ssoService;

    @Autowired
    private CookieServiceI cookieService;


    /**
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        //清除session
        request.getSession().removeAttribute("user");
        //清除cookie
        cookieService.deleteCookie(request,response);
        //清除redis
        String ticket = cookieService.getCookie(request);
        ssoService.Logout(ticket);
        return "index";
    }

    /**
     * 用户登录
     * @param admin
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public BaseResult login(Admin admin, HttpServletRequest request, HttpServletResponse response){

        String ticket = ssoService.Login(admin);
        System.out.println("ticket:"+ticket);
        //票据信息存在,设置至cookie
        if(null!=ticket && ticket.length()>0){
            cookieService.setCookie(request,response,ticket);
            return  BaseResult.success();
        }

        return BaseResult.error();
    }
}
