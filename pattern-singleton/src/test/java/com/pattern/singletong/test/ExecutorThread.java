package com.pattern.singletong.test;

import com.pattern.singleton.lazy.LazyDoubleCheckSingleton;
import com.pattern.singleton.lazy.LazyInnerClassSingleton;
import com.pattern.singleton.lazy.LazySimpleSingleton;
import com.pattern.singleton.threadlocal.ThreadLocalSingleton;

// 用两个线程演示多线程的执行过程
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
//        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
//        LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
        LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + singleton);
//
//        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
//        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
//        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
    }
}
