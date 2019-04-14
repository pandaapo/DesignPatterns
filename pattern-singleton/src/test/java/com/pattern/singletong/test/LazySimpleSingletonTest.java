package com.pattern.singletong.test;

import com.pattern.singleton.lazy.LazySimpleSingleton;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
//        LazySimpleSingleton.getInstance();

        //两个线程
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();

        System.out.println("executor end");
        System.out.println(t1 == t2);
    }
}
