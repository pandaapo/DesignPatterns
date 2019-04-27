package com.pattern.adapter.loginadapter.v2;

public class PassportTest {
    public static void main(String[] args) {
        IPassPortForThird passPortForThird = new PassPortForThirdAdapter();
        passPortForThird.loginForQQ("");
    }
}
