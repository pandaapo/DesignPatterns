package com.pattern.singletong.test;

import com.pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;


public class LazyInnerClassSingletonTest {
    //调试内部类形式的懒汉式单例
    public static void main(String[] args) {

        LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
        System.out.println(singleton);
//        //两个线程
//        Thread t1 = new Thread(new ExecutorThread());
//        Thread t2 = new Thread(new ExecutorThread());
//
//        t1.start();
//        t2.start();
//
//        System.out.println("executor end");
//        System.out.println(t1 == t2);
    }

//    // 利用反射攻击单例的私有构造方法
//    public static void main(String[] args) {
//        try {
//            Class<?> clazz = LazyInnerClassSingleton.class;
//            Constructor c= clazz.getDeclaredConstructor(null);
//            c.setAccessible(true);
//            Object o1 = c.newInstance();
//            Object o2 = LazyInnerClassSingleton.getInstance();
//            System.out.println(o1 == o2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
