package com.pattern.strategy.pay.payport;

import com.pattern.strategy.pay.MsgResult;

/**
 * 支付。支付的运算逻辑
 */
public abstract class Payment {

    //支付方法
    public abstract String getName();

    //查询余额
    protected abstract double queryBalance(String uid);

    //支付逻辑
    public MsgResult pay(String uid, double amount){
        if(queryBalance(uid) < amount){
            return new MsgResult(500, "余额不足", "支付失败");
        }
        return new MsgResult(200, "支付金额：" + amount, "支付成功");
    }

}
