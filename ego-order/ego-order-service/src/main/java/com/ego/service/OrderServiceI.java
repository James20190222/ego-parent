package com.ego.service;

import com.ego.pojo.Admin;
import com.ego.result.BaseResult;
import com.ego.result.CartResult;

/**
 * Created by zhong on 2019/4/21.
 */
public interface OrderServiceI {

    //保存订单
   BaseResult orderSave(Admin admin, CartResult cartResult);
}
