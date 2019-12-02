package com.ego.vo;

import java.io.Serializable;
import java.util.List;

/**
 *  商品属性或规格通用返回对象
 * Created by zhong on 2019/4/10.
 */
public class SpecOrAttributeVo implements Serializable {

    private Integer  id;
    private String []value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}
