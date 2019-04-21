package com.pattern.strategy.promotion;

//促销活动
public class PromotionActivity {
    //保存优惠策略
    PromotionStrategy promotionStrategy;

    //选择优惠策略
    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    //开展活动
    public void execute(){
        this.promotionStrategy.doPromotion();
    }
}
