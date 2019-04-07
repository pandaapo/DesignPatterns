package com.pattern.factory.abstractfactory;

import com.pattern.factory.ICourse;
import com.pattern.factory.INote;
import com.pattern.factory.IVideo;

/**
 * python工厂
 * 在刚创建这个工厂的时候，可能具体的产品(PythonCourse,PythonNote,PythonVideo)还没有。
 */
public class PythonFactory implements IProductFactory {
    @Override
    public ICourse createCourse() {
        return null;
    }

    @Override
    public INote createNote() {
        return null;
    }

    @Override
    public IVideo createVideo() {
        return null;
    }
}
