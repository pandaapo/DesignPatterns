package com.pattern.strategy.promotion;

public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满20人成团，全团享受团购价");
    }
}
