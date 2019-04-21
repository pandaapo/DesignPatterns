package com.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂
 */
public class PayStrategy {
    public static final String ALI_PAY = "Alipay";
    public static final String JD_PAY = "JDpay";
    public static final String WECHAT_PAY = "Wechatpay";
    public static final String UNION_PAY = "Unionpay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> payStrategy = new HashMap<String,Payment>();

    static {
        payStrategy.put(ALI_PAY, new AliPay());
        payStrategy.put(JD_PAY, new JDPay());
        payStrategy.put(WECHAT_PAY,new WechatPay());
        payStrategy.put(UNION_PAY, new UnionPay());
    }

    //提供统一访问点。实现动态策略。
    public static Payment get(String payKey){
        if(!payStrategy.containsKey(payKey)){
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }
}
