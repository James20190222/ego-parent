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

    @RequestMapping("/getCartList")
    public String getCartList(HttpServletRequest request,Model model){
        //从session获取用户信息
        Admin admin = (Admin) request.getSession().getAttribute("user");
        model.addAttribute("cartList",cartService.getCartList(admin));
        return "cart/cart";
    }


    /**
     *  添加购物车
     * @param request
     * @param goodsVo
     * @return
     */
    @RequestMapping("/addToCart")
    @ResponseBody
    public BaseResult addToCart(HttpServletRequest request,GoodsVo goodsVo){
        goodsVo.setAddTime(new Date());
        System.out.println("购物车商品添加时间:"+goodsVo.getAddTime());
        //从session获取用户信息
        Admin admin = (Admin) request.getSession().getAttribute("user");
        //加入购物车
        return cartService.addToCart(admin,goodsVo);
    }


    @RequestMapping("/getCartNum")
    @ResponseBody
    public Integer getCartNum(HttpServletRequest request){
        //从session获取用户信息
        Admin admin = (Admin) request.getSession().getAttribute("user");
        //查询购物车中商品数量
        return cartService.getCartNum(admin);
    }

    //删除购物车商品
    @RequestMapping("/deleteCart")
    @ResponseBody
    public BaseResult deleteCart(HttpServletRequest request,Integer goodsId){
        //从session获取用户信息
        Admin admin = (Admin) request.getSession().getAttribute("user");
        return cartService.deleteCart(admin, goodsId);
    }

    //清空购物车
    @RequestMapping("/clearCart")
    @ResponseBody
    public BaseResult clearCart(HttpServletRequest request){
        //从session获取用户信息
        Admin admin = (Admin) request.getSession().getAttribute("user");
        return cartService.clearCart(admin);
    }
}
