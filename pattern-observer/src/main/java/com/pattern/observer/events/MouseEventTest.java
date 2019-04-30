package com.pattern.observer.events;

import com.pattern.observer.events.mouseevent.Mouse;
import com.pattern.observer.events.mouseevent.MouseEventCallback;
import com.pattern.observer.events.mouseevent.MouseEventType;

public class MouseEventTest {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        MouseEventCallback callback = new MouseEventCallback();
        //先监听
        mouse.addListener(MouseEventType.ON_CLICK, callback);
        mouse.click();
    }
}
