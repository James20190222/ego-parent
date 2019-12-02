package com.ego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *  订单controller
 * Created by zhong on 2019/4/21.
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    /**
     * 跳转订单系统
     * @return
     */
    @RequestMapping("/toPreOrder")
    public String toPreOrder(HttpServletRequest request){
        return "redirect:"
                + request.getSession().getServletContext().getAttribute("orderUrl")
                +"order/preOrder";
    }

    /**
     * 订单提交成功,异步回调方法
     * @return
     */
    @RequestMapping("/callBack")
    public String callBack(Model model){
        model.addAttribute("result","success");
        System.out.println("支付成功!");
        return  "/order/pay";
    }
}
