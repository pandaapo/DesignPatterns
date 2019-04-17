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
public class HunJieSuo implements InvocationHandler {

    private Person target;

    //提供注入的方法？？？
    public Object getInstance(Person person) throws Exception{
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target);
    }
}
