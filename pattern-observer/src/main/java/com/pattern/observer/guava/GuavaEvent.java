package com.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    //加了该注解，这个方法就会被监听/被观察
    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是:" + str);
    }
}
