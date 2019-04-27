package com.pattern.adapter.loginadapter.v2.adapters;

import com.pattern.adapter.loginadapter.ResultMsg;

public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String id, Object a) {
        return null;
    }
}
