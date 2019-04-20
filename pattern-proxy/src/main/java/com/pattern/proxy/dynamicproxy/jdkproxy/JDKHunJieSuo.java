package com.pattern.proxy.dynamicproxy.jdkproxy;

import com.pattern.proxy.Person;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//InvokeHandler，功能增强，但不影响目标对象的原始需求
public class JDKHunJieSuo implements InvocationHandler {

    private Object target;

    //提供注入的方法？？？
    public Object getInstance(Object person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        //jdk的一种写法
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
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
