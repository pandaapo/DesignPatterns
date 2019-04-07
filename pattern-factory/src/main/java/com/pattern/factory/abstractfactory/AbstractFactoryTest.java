package com.pattern.factory.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IProductFactory factory = new JavaFactory();
        factory.createCourse().record();
        factory.createNote();
        factory.createVideo();
    }
}
