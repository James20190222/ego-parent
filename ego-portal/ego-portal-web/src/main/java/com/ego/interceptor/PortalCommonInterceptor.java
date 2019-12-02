package com.ego.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  全局拦截器
 * Created by zhong on 2019/4/21.
 */
@Component("portalCommonInterceptor")
public class PortalCommonInterceptor implements HandlerInterceptor {

    @Value("${ego.order.url}")
    private String orderUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ServletContext context = request.getSession().getServletContext();
            String url = (String) context.getAttribute("orderUrl");
         if(null==url || orderUrl.length()<=0){
             context.setAttribute("orderUrl", orderUrl);
         }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
