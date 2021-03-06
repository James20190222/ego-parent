package com.ego.interceptor;

import com.ego.pojo.Admin;
import com.ego.service.SSOServiceI;
import com.ego.util.CookieUtil;
import com.ego.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Created by James on 2019/4/9 0009.
 */
@Component("portalLoginInterceptor")
public class PortalLoginInterceptor implements HandlerInterceptor {

    @Value("${user.ticket}")
    private String userTicket;

    @Autowired
    private SSOServiceI ssoService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        //验证票据是否存在
        String ticket = CookieUtil.getCookieValue(httpServletRequest, userTicket);
        //如果票据不存在,请登录
        if(null !=ticket && ticket.length()>0){
            //验证票据,获取用户信息
            Admin admin = ssoService.validate(ticket);
            if(null != admin){
                //将用户信息设置到session
                httpServletRequest.getSession().setAttribute("user",admin);
                redisTemplate.opsForValue().set(userTicket+":"+ ticket,
                        JsonUtil.object2JsonStr(admin),1800, TimeUnit.SECONDS);
            }else {
                //清除session信息
                httpServletRequest.getSession().removeAttribute("user");
            }
        }else {
            //清除session信息
            httpServletRequest.getSession().removeAttribute("user");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
