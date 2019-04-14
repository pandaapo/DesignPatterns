package com.pattern.singleton.lazy;

public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton () {}

    //synchronized写在方法上会导致类被锁住的解决方案
    //双重检查锁
    public static LazyDoubleCheckSingleton getInstance() {
        // 将synchronized写在方法里面，避免整个类被锁住，提高性能
        if(lazy == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if(lazy == null){
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }

    /**
     * 指令重排序问题，解决方案：关键字volatile
     * cpu执行的时候会转换成JVM指令执行，
     * 执行顺序，
     * 1、分配内存给对象
     * 2/3：初始化对象
     * 3/2：将对象和内存地址建立关联，即赋值
     * 4、用户初次访问
     * 其中第2步和第3步的顺序不固定。
     */
}
