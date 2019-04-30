package com.pattern.observer.events.mouseevent;

import com.pattern.observer.events.core.Event;

/**
 * 自己定义的回调
 */
public class MouseEventCallback {

    public void onClick (Event e) {
        System.out.println("======触发鼠标单击事件=====" +"\n"+ e);
    }

    public void onDoubleClick(Event e){
        System.out.println("======触发鼠标双击事件=====" +"\n"+ e);
    }

    public void onUp(Event e){
        System.out.println("======触发鼠标弹起事件=====" +"\n"+ e);
    }

    public void onDown(Event e){
        System.out.println("======触发鼠标按下事件=====" +"\n"+ e);
    }

    public void onOver(Event e){
        System.out.println("======触发鼠标悬停事件=====" +"\n"+ e);
    }

    public void onFocus(Event e){
        System.out.println("======触发鼠标失焦事件=====" +"\n"+ e);
    }
}
