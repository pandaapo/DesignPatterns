package com.pattern.adapter.loginadapter.v1;

import com.pattern.adapter.loginadapter.ResultMsg;

//实现第三方登录一种适配方式：继承，原来的登陆方式保留不动
public class SignForThirdService extends SignService {
    //qq登录
    public ResultMsg loginForQQ(String openid){
        //1、openid是全局唯一我们可以把它当做是一个用户名
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）
        //4、调用原来的登录方法
        return logForRegister(openid, null);
    }

    //微信登录
    public ResultMsg loginForWechat(String openid){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后再重新登录一次
        return null;
    }

    public ResultMsg loginForTelphone(String telphone, String code){
        return null;
    }

    //自动注册，并登录
    private ResultMsg logForRegister(String username, String password) {
        super.register(username, null);
        return super.login(username, null);
    }

}
