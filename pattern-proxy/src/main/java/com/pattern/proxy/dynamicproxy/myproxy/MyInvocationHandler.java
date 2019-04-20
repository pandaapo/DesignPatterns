package com.pattern.proxy.dynamicproxy.myproxy;

import java.lang.reflect.Method;

//自己写个动态代理实现机制，模仿生成代码的过程>>>

public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
