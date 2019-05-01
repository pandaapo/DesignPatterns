package com.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

public class GuavaEventTest {
    //之前两个案例面向的是类，guava面向的是方法。
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("hello");
    }
}
