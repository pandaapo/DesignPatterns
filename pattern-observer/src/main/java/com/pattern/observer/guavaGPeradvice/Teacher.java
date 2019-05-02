package com.pattern.observer.guavaGPeradvice;

import com.google.common.eventbus.Subscribe;

/**
 * 老师
 */
public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    /**
     * GPer的事件监听器/事件处理器/观察者
     */
    @Subscribe
    public void getNotice(GPer gPer){
        System.out.println("+++++++++++++\n"
                +name + "老师，\n"
                +"您收到一个来自" +gPer.getName()+ "社区的一个问题：");
    }

    /**
     * Question的事件监听器/事件处理器/观察者
     */
    @Subscribe
    public void getNoticeContent(Question question){
        System.out.println(question.getContent() + "\n"
                +"提问者：" + question.getUsername());
    }
}
