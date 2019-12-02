package com.ego.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie service
 * Created by James on 2019/4/9 0009.
 */
public interface CookieServiceI {
    /**
     * 设置cookie
     * @param request
     * @param response
     * @param cookieValue
     * @return
     */
        boolean setCookie(HttpServletRequest request, HttpServletResponse response,String cookieValue);

    /**
     *  删除cookie
     * @param request
     * @param response
     * @return
     */
        boolean deleteCookie(HttpServletRequest request, HttpServletResponse response);

    /**
     *  获取cookie
     * @param request
     * @return
     */
        String getCookie(HttpServletRequest request);
}
