package com.pattern.factory.simplefactory;

import com.pattern.factory.ICourse;
import com.pattern.factory.JavaCourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();

//        ICourse course = courseFactory.create("java");

//        ICourse course = courseFactory.create("com.pattern.factory.JavaCourse");

        ICourse course = courseFactory.create(JavaCourse.class);
        course.record();
    }
}
