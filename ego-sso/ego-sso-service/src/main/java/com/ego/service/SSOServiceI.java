package com.ego.service;

import com.ego.pojo.Admin;

/**
 * 单点登录服务
 * Created by James on 2019/4/8 0008.
 */
public interface SSOServiceI {

    /**
     *  安全退出
     * @param ticket
     */
    public void Logout(String ticket);

    /**
     * 登录认证,登录成功返回ticket票据信息
     * @param admin
     * @return
     */
    String Login(Admin admin);

    /**
     * 通过ticket票据信息验证,验证成功返回用户信息
     * @param ticket
     * @return
     */
    Admin validate(String ticket);
}
