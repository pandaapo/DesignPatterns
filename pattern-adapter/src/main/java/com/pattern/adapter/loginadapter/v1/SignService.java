package com.pattern.adapter.loginadapter.v1;

import com.pattern.adapter.loginadapter.Member;
import com.pattern.adapter.loginadapter.ResultMsg;

//登录业务
public class SignService {

    //注册
    public ResultMsg register(String username, String password){
        return  new ResultMsg(200,"注册成功！", new Member(username, password, "",""));
    }

    //登录
    public ResultMsg login(String username, String password){
        return  null;
    }
}
