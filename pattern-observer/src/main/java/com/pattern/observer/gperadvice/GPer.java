package com.pattern.observer.gperadvice;

import java.util.Observable;

/**
 * JDK提供的一种观察者实现方式
 * 被观察者：GPer社区
 */
public class GPer extends Observable {

    private String name = "GPer生态圈";
    //单例
    private static GPer gper = null;

    private GPer(){}

    public static GPer getInstance(){
        if(null == gper){
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(this.name + "上，" + question.getUserName() +"提问：" + question.getContent());
        //标识被观察者发生变化
        setChanged();
        //对应观察者update方法中的第二个参数arg
        notifyObservers(question);
    }

}
