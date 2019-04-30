package com.pattern.observer.events.mouseevent;

/**
 * 鼠标的几种事件类型
 */
public interface MouseEventType {
    String ON_CLICK = "click";

    String ON_DOUBLE_CLICK = "doubleClick";

    String ON_UP = "up";

    String ON_DOWN = "down";

    String ON_MOVE = "move";

    String ON_WHEEL = "wheel";

    String ON_OVER = "over";

    String ON_BLUR = "blur";

    String ON_FOCUS = "focus";
}
