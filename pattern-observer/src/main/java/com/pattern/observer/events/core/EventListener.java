package com.pattern.observer.events.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Event的观察者
 */
public class EventListener {

    //JDK底层的Listener也类似：用这个map保存所有的事件，即保存被观察者
    protected Map<String,Event> events = new HashMap<>();

    //根据事件名称和目标对象添加监听
    public void addListener(String eventType, Object target){
        try{
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //根据事件名称、目标对象和回调函数添加监听
    public void addListener(String eventType, Object target, Method callback){
        //注册事件
        events.put(eventType, new Event(target, callback));
    }

    //根据事件触发：触发事件时执行
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try{
            //用反射调用回调函数
            event.getCallback().invoke(event.getTarget(), event);
        }catch (Exception e){

        }
    }

    //根据事件名触发。
    protected void trigger(String trigger){
        if(!this.events.containsKey(trigger)) return;
        trigger(this.events.get(trigger).setTrigger(trigger));
    }

    private String toUpperFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
