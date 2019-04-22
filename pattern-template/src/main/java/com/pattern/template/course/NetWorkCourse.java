package com.pattern.template.course;

public abstract class NetWorkCourse {
    protected final void createCourse(){
        //1 发布预习资料
        this.postPreResource();
        //2 制作ppt
        this.createPPT();
        //3 在线直播
        this.liveVideo();
        //4 提交课堂笔记
        this.postNote();
        //5 提交源码
        this.postSource();
        //6 布置作业：没有作业时，本课完成；有作业时，需要检查作业
        if(needHomeWork()){
            checkHomeWord();
        }

    }

    //检查作业可以由不同课程进行定制化
    abstract void checkHomeWord();

    //钩子方法，留给用户去微调的方法，该方法可以控制流程的微调。
    protected boolean needHomeWork() {
        return false;
    }

    final void postSource() {
        System.out.println("提交源代码");
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void liveVideo() {
        System.out.println("在线直播授课");
    }

    final void createPPT(){
        System.out.println("创建备课的PPT");
    };


    //final“由老师发布，不能被其他人干预”，不让子类修改该方法
    final void postPreResource() {
        System.out.println("老师发布预习资料");
    };
}
