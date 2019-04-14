package com.pattern.singleton.threadlocal;

//注册式单例-ThreadLocal式
//在线程内是安全的，跨线程是不同实例
//应用场景：使用ThreadLocal来实现多数据源的动态切换
public class ThreadLocalSingleton {
    private ThreadLocalSingleton() {}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
