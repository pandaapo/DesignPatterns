package com.pattern.proxy.dbroute.proxy;

import com.pattern.proxy.dbroute.IOrderService;
import com.pattern.proxy.dbroute.Order;
import com.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

//代理数据源切换逻辑
public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    //将orderService通过构造方法引入进来。这是一种静态代理（这里只能代理IOrderService）
    private IOrderService orderService;

    public OrderServiceStaticProxy (IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +dbRouter+ "】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);

        this.orderService.createOrder(order);

        //结束以后要切换回来
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
