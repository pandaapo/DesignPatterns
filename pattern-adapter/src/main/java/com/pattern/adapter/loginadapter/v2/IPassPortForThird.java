package com.pattern.adapter.loginadapter.v2;

import com.pattern.adapter.loginadapter.ResultMsg;

//只用于扩展
public interface IPassPortForThird {
    /**
     * QQ登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     * @param telphone
     * @return
     */
    ResultMsg loginForTelphone(String telphone);

    /**
     * 注册后自动登录
     * @param username
     * @param password
     * @return
     */
    ResultMsg loginForRegister(String username, String password);
}
