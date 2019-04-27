package com.pattern.decorator.v2;

public class BatterCakeTest {
    public static void main(String[] args) {
        BatterCake batterCake = new BaseBatterCake();
        //煎饼有点小，加个鸡蛋
        batterCake = new EggDecorator(batterCake);
        //再加一个鸡蛋
        batterCake = new EggDecorator(batterCake);
        //再加根香肠
        batterCake = new SausageDecorator(batterCake);

        System.out.println(batterCake.getMsg() + ", 总价：" + batterCake.getPrice());
    }
}
