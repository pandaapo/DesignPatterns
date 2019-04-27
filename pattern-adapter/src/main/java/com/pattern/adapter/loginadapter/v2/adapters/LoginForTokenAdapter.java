package com.pattern.adapter.loginadapter.v2.adapters;

import com.pattern.adapter.loginadapter.ResultMsg;

public class LoginForTokenAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object a) {
        return null;
    }
}
