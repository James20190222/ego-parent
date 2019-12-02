package com.ego.service.impl;

import com.ego.mapper.AdminMapper;
import com.ego.pojo.Admin;
import com.ego.pojo.AdminExample;
import com.ego.service.SSOServiceI;
import com.ego.util.JsonUtil;
import com.ego.util.Md5Util;
import com.ego.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 单点登录服务的实现
 * Created by James on 2019/4/8 0008.
 */
public class SSOServiceImpl implements SSOServiceI{

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${user.ticket}")
    private String userTicket;

    private static Logger logger= LoggerFactory.getLogger(SSOServiceImpl.class);


    /**
     * 安全退出
     * @param ticket
     */
    @Override
    public void Logout(String ticket) {
        redisTemplate.delete(userTicket + ":" + ticket);
    }

    /**
     * 登录验证
     * @param admin
     * @return
     */
    @Override
    public String Login(Admin admin) {
        String username=admin.getUserName().trim();
        String password=admin.getPassword().trim();
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        //验证用户名和密码的合法性
        if(null!=username && username.length()>0){
            if(null!=password && password.length()>0){
                //验证用户是否存在
                AdminExample adminExample = new AdminExample();
                adminExample.createCriteria().andUserNameEqualTo(username);
                List<Admin> adminList = adminMapper.selectByExample(adminExample);
                //验证用户名是否唯一
                if(!adminList.isEmpty()){
                   if(adminList.size()!=1){
                       logger.error("该用户名存在多个用户,用户名为:"+username);
                   }
                    //验证密码是否正确
                    Admin admin1 = adminList.get(0);
                   //获取输入密码加密后的"密码"
                    String md5WithSalt = Md5Util.getMd5WithSalt(password, admin1.getEcSalt());
                    if(admin1.getPassword().equals(md5WithSalt)){
                        //密码正确,将用户信息存入缓存,返回票据ticket
                        String ticket=UUIDUtil.getUUID();
                        redisTemplate.opsForValue().set(userTicket+":"+ ticket,
                                JsonUtil.object2JsonStr(admin1),1800, TimeUnit.SECONDS);
                        return ticket;
                    }else {
                        logger.error("用户名或密码错误!");
                    }
                }else {
                    logger.error("用户名或密码不存在!");
                }
            }
        }
        logger.error("用户或密码为空!");
        return null;
    }

    /**
     * 票据验证
     * @param ticket
     * @return
     */
    @Override
    public Admin validate(String ticket) {
        String adminStr = redisTemplate.opsForValue().get(userTicket + ":" + ticket);
        if(null!=adminStr && adminStr.length()>0){
            return JsonUtil.jsonStr2Object(adminStr, Admin.class);
        }
        return null;
    }
}
