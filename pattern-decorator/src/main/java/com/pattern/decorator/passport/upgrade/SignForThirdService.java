package com.pattern.decorator.passport.upgrade;

import com.pattern.decorator.passport.old.ISigninService;
import com.pattern.decorator.passport.old.ResultMsg;

public class SignForThirdService implements ISignForThirdService {
    //被包装者
    private ISigninService signinService;

    public SignForThirdService(ISigninService signinService) {
        this.signinService = signinService;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return signinService.regist(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return signinService.login(username, password);
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegister(String username, String password) {
        return null;
    }
}
