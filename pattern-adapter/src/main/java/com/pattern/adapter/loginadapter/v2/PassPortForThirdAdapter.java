package com.pattern.adapter.loginadapter.v2;

import com.pattern.adapter.loginadapter.ResultMsg;
import com.pattern.adapter.loginadapter.v1.SignService;
import com.pattern.adapter.loginadapter.v2.adapters.*;

/**
 * 一个既实现扩展接口、又兼容原来登录功能的适配器
 * 适配器模式，工厂模式，代理模式
 */
public class PassPortForThirdAdapter extends SignService implements IPassPortForThird {

    @Override
    public ResultMsg loginForQQ(String id) {
        //策略模式：用户根据不同场景选择不同的逻辑，LoginForQQAdapter.class
        return processLogin(id,LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone) {
        return processLogin(telphone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegister(String username, String password) {
        super.register(username, password);
        return super.login(username,password);
    }

    /**
     * 简单工厂：处理重复代码
     * @param key
     * @param clazz
     * @return
     */
    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz){
        try {
            //适配器不一定要实现接口
            LoginAdapter adapter = null;
            adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.login(key, adapter);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
