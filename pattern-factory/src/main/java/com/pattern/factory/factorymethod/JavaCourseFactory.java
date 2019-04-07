package com.pattern.factory.factorymethod;

import com.pattern.factory.ICourse;
import com.pattern.factory.JavaCourse;

/**
 * Java课程创建工厂
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
