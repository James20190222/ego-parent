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
@Component("orderCommonInterceptor")
public class OrderCommonInterceptor implements HandlerInterceptor {

    @Value("${ego.portal.url}")
    private String portalUrl;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ServletContext context = request.getSession().getServletContext();
            String url = (String) context.getAttribute("portalUrl");
         if(null==url || portalUrl.length()<=0){
             context.setAttribute("portalUrl", portalUrl);
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
