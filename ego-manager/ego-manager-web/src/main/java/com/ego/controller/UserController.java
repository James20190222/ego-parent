package com.ego.controller;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.result.BaseResultEnum;
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
        return "login";
    }

    /**
     * 用户登录
     * @param admin
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public BaseResult login(Admin admin,String vertify, HttpServletRequest request, HttpServletResponse response){

        BaseResult result=null;
        //获取验证码信息
        //非空校验
        if(null==vertify || vertify.trim().length()<=0){
            result=BaseResult.error();
            result.setCode(BaseResultEnum.PASS_ERROR_04.getCode());
            result.setMessage(BaseResultEnum.PASS_ERROR_04.getMessage());
            return result;
        }
        //正确校验
        String code= (String) request.getSession().getAttribute("pictureVerifyKey");
        if(!vertify.trim().equals(code)){
            result=BaseResult.error();
            result.setCode(BaseResultEnum.PASS_ERROR_03.getCode());
            result.setMessage(BaseResultEnum.PASS_ERROR_03.getMessage());
            return result;
        }

        //校验票据获取用户信息
        String ticket = ssoService.Login(admin);
        System.out.println("ticket:"+ticket);
        //票据信息存在,设置至cookie
        if(null!=ticket && ticket.length()>0){
            cookieService.setCookie(request,response,ticket);
            return  BaseResult.success();
        }

        //用户名密码错误
        result=BaseResult.error();
        result.setCode(BaseResultEnum.PASS_ERROR_05.getCode());
        result.setMessage(BaseResultEnum.PASS_ERROR_05.getMessage());
        return result;
    }
}
