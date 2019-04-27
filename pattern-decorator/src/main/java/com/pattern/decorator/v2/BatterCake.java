package com.pattern.decorator.v2;

/**
 * 经常变化的煎饼，抽象成顶层的抽象类
 */
public abstract class BatterCake {
    protected abstract String getMsg();

    protected abstract int getPrice();
}
