package com.pattern.proxy.dbroute;

import com.pattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.pattern.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBRouteProxyTest {

    public static void main(String[] args) {
        try {
            Order order = new Order();
//            order.setCreateTime(new Date().getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2017-12-31");
            order.setCreateTime(date.getTime());

//            //通过静态代理实现数据源的动态切换
//            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            //通过动态代理实现数据源的切换。必须是接口IOrderService，接口中必须有需要代理的方法。
            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
