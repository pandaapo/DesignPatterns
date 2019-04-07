package com.pattern.factory.factorymethod;

import com.pattern.factory.ICourse;

/**
 * 顶层工厂接口
 */
public interface ICourseFactory {
    ICourse create();
}
