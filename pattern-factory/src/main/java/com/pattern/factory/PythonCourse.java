package com.pattern.factory;

/**
 * Python课程
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Python课程 ");
    }
}
