package com.pattern.template.course;

public class BigDataCourse extends NetWorkCourse {

    //是否有课后作业
    private boolean needHomeWorkFlag = false;

    public BigDataCourse(boolean needHomeWork) {
        this.needHomeWorkFlag = needHomeWork;
    }

    @Override
    void checkHomeWord() {
        System.out.println("检查大数据课程的作业");
    }

    //重写钩子方法
    @Override
    protected boolean needHomeWork() {
        return this.needHomeWorkFlag;
    }
}
