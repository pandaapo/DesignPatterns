package com.pattern.factory.factorymethod;

import com.pattern.factory.ICourse;

public class FactoryMethodTest {

    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}
