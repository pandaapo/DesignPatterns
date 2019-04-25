package com.pattern.adapter.loginadapter.v1;

public class SignForThirdServiceTest {
    public static void main(String[] args) {

        SignForThirdService service = new SignForThirdService();
        service.login("tom","123456");
        service.loginForQQ("openid");
        service.loginForWechat("openid");
    }
}
