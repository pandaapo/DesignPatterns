package com.pattern.decorator.v2;

public class SausageDecorator extends BatterCakeDecorator {
    @Override
    protected void doSomething() {

    }

    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+ 1个香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
