package com.pattern.adapter.loginadapter.v2.adapters;

import com.pattern.adapter.loginadapter.ResultMsg;

public class LoginForQQAdapter implements LoginAdapter {
    //判断是否是通过QQ登录
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object a) {
        return null;
    }
}
