package com.pattern.strategy.pay;

import com.pattern.strategy.pay.payport.PayStrategy;

public class PayStrategyTest {
    public static void main(String[] args) {
        //创建订单
        Order order = new Order("1", "20190421001", 324.56);

        //用户选择一种支付方式
        MsgResult result = order.pay(PayStrategy.ALI_PAY);
        System.out.println(result);
    }
}
