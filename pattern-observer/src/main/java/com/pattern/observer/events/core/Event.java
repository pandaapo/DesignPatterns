package com.pattern.observer.events.core;

import java.lang.reflect.Method;

/**
 * 标准事件源格式的定义
 */
public class Event {
    //事件源：记录事件是由谁发起的
    private Object source;
    //事件触发后通知的对象
    private Object target;
    //事件触发时要做的动作
    private Method callback;
    //事件的名称
    private String trigger;
    //事件触发的时间
    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Object getSource() {
        return source;
    }

    public Object getTarget() {
        return target;
    }

    public Method getCallback() {
        return callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source + "\n" +
                ", target=" + target + "\n" +
                ", callback=" + callback  + "\n" +
                ", trigger='" + trigger + '\'' + "\n" +
                ", time=" + time +
                '}';
    }
}
