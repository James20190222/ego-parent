package com.ego.util;

import java.util.UUID;

/**
 *  UUID工具类
 * Created by James on 2019/3/27 0027.
 */
public class UUIDUtil {
    /*
    * 返回UUID将"-"替换为""
    * */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
