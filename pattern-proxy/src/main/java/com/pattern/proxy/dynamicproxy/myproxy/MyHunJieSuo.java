package com.pattern.proxy.dynamicproxy.myproxy;

import com.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//InvokeHandler，功能增强，但不影响目标对象的原始需求
public class MyHunJieSuo implements MyInvocationHandler {

    private Person target;

    //提供注入的方法？？？
    public Object getInstance(Person person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    //动态代理的“增强”
    private void before() {
        System.out.println("我是婚介所，已明确您的需求，开始物色");
    }

    //动态代理的“增强”
    private void after() {
        System.out.println("已经为您推荐一位");
    }
}
