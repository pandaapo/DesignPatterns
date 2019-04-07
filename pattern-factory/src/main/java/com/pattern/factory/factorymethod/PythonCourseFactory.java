package com.pattern.factory.factorymethod;

import com.pattern.factory.ICourse;
import com.pattern.factory.JavaCourse;
import com.pattern.factory.PythonCourse;

/**
 * Python课程创建工厂
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
