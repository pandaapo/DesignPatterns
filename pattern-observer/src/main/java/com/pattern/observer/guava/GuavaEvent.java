package com.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    //加了该注解，这个方法就成为监听器，在"String"事件发成变化时就会触发，传入了String类型参数就表示发生了变化。
    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是:" + str);
    }
}
