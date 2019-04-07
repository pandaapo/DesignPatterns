package com.pattern.factory.abstractfactory;

import com.pattern.factory.ICourse;
import com.pattern.factory.INote;
import com.pattern.factory.IVideo;

/**
 * 顶层工厂,所有子工厂都要实现该工厂。
 * 该工厂是一个产品族的抽象。
 */
public interface IProductFactory {

    ICourse createCourse();

    INote createNote();

    IVideo createVideo();
}
