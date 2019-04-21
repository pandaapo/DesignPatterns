package com.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//动态生成原代码，继承传入的class
public class CGlibHunJieSuo implements MethodInterceptor {

    //先把引用传进来
    public Object getInstance(Class<?> clazz) throws Exception{
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        //回调调的是intercept方法
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return null;
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
