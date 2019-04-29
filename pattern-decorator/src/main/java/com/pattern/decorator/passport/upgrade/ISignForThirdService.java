package com.pattern.decorator.passport.upgrade;

import com.pattern.decorator.passport.old.ISigninService;
import com.pattern.decorator.passport.old.ResultMsg;

/**
 * 抽象装饰者
 */
public interface ISignForThirdService extends ISigninService {
    //扩展
    /**
     * qq登录
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     */
    ResultMsg loginForTelphone(String telphone, String code);

    /**
     * 注册后自动登录
     */
    ResultMsg loginForRegister(String username, String password);
}
