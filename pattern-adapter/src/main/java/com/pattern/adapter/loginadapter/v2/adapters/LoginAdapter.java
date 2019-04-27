package com.pattern.adapter.loginadapter.v2.adapters;

import com.pattern.adapter.loginadapter.ResultMsg;

/**
 * 一种业内推荐的适配器写法
 * 在适配器模式中，这个接口是可有可无的
 * 在模板模式中，一定是抽象类。
 */
public interface LoginAdapter {
    //判断是否兼容
    boolean support(Object adapter);

    ResultMsg login(String id, Object a);

}
