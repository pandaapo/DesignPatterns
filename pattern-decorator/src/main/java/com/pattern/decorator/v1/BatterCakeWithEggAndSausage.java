package com.pattern.decorator.v1;

/**
 * 加香肠 加鸡蛋的煎饼
 */
public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg{
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
