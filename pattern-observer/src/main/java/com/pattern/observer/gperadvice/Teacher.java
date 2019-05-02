package com.pattern.observer.gperadvice;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者，一般是异步的：老师
 */
public class Teacher implements Observer {
    private String name;
    public Teacher(String name){
        this.name = name;
    }

    //当被观察者有变化时就会调用update
    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer)o;
        Question question = (Question)arg;
        System.out.println("+++++++++++++++++++++++");
        System.out.println(name + "老师，\n" +
                "您收到一个来自" +gper.getName()+ "社区的一个问题：\n" +
                question.getContent() + "\n" +
                "提问者：" + question.getUserName());

    }
}
