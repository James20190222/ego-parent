package com.ego.interceptor;

import com.ego.pojo.Admin;
import com.ego.service.SSOServiceI;
import com.ego.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  购物车拦截器
 * Created by zhong on 2019/4/20.
 */
@Component("cartInterceptor")
public class CartInterceptor implements HandlerInterceptor {

    @Value("${user.ticket}")
    private String userTicket;

    @Autowired
    private SSOServiceI ssoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证票据是否存在
        String ticket = CookieUtil.getCookieValue(request, userTicket);
        //如果票据不存在,请登录
        if(null !=ticket && ticket.length()>0){
            //验证票据,获取用户信息
            Admin admin = ssoService.validate(ticket);
            if(null != admin){
                //将用户信息设置到session
                request.getSession().setAttribute("user",admin);
                return true;
            }
        }
        //重定向至登录页面
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
