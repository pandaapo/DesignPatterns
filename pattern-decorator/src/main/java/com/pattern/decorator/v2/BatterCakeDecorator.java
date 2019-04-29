package com.pattern.decorator.v2;

/**
 * 抽象煎饼包装器
 */
public abstract class BatterCakeDecorator extends BatterCake {
    //将被包装类通过构造函数赋值进来，作为组成部分。一种静态代理？？？
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    //一点扩展
    protected  abstract void doSomething();

    @Override
    protected String getMsg() {
        return batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return batterCake.getPrice();
    }
}
