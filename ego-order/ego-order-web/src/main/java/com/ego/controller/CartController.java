package com.ego.controller;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.service.CartServiceI;
import com.ego.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zhong on 2019/4/20.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceI cartService;


    @RequestMapping("/getCartNum")
    @ResponseBody
    public Integer getCartNum(HttpServletRequest request){
        //从session获取用户信息
        Admin admin = (Admin) request.getSession().getAttribute("user");
        //查询购物车中商品数量
        return cartService.getCartNum(admin);
    }

}
