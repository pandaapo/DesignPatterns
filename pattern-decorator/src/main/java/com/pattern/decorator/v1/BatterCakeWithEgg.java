package com.pattern.decorator.v1;

/**
 * 加鸡蛋的煎饼
 */
public class BatterCakeWithEgg extends Battercake {
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
