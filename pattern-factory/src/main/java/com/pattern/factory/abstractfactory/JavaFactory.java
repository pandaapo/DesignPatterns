package com.pattern.factory.abstractfactory;

import com.pattern.factory.*;

/**
 * java工厂
 */
public class JavaFactory implements IProductFactory {

    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
