package com.pattern.factory.simplefactory;

import com.pattern.factory.ICourse;

/**
 * 假设创建课程的逻辑很复杂，用简单工厂封装这些创建过程
 */
public class CourseFactory {
//    public ICourse create(String name) {
//        if("java".equals(name)){
//            return new JavaCourse();
//        } else {
//            return null;
//        }
//    }

//    public ICourse create (String className) {
//        try {
//            if(!(null == className || "".equals(className))) {
//                return (ICourse)Class.forName(className).newInstance();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public ICourse create (Class clzz) {
        try {
            if(null != clzz) {
                return (ICourse)clzz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
