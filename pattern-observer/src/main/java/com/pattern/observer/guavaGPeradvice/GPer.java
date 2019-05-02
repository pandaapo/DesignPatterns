package com.pattern.observer.guavaGPeradvice;

/**
 * 事件：GPer生态圈
 */
public class GPer {
    private String name = "GPer生态圈";

    private static GPer gPer;

    private GPer(){};

    public static GPer getInstance(){
        if(gPer == null) {
            gPer = new GPer();
        }
        return gPer;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println("在" + this.name + "上，" + question.getUsername() + "提出了问题：" + question.getContent());
    }
}
