package com.pattern.proxy.dbroute.proxy;

import com.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

//动态代理实现数据源切换
public class OrderServiceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    Object proxyObj;
    public Object getInstance(Object proxyObj){
        //将代理对象的引用传进来
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //先写死：只有一个参数
        before(args[0]);
        Object obj = method.invoke(proxyObj,args);
        after();
        return obj;
    }

    //还原成默认的数据源
    private void after() {
        System.out.println("还原成默认的数据源");
        DynamicDataSourceEntity.restore();
    }

    //进行数据源的切换。target是订单对象Order
    private void before(Object target) {
        try {
            System.out.println("进行数据源的切换");
            Method method = target.getClass().getMethod("getCreateTime");
            Long time = (Long)method.invoke(target);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_" +dbRouter+ "】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
