package com.pattern.singleton.lazy;

//静态内部类
//没有用到synchronized，性能更好
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton () {
        // 虽然构造方法私有化了，但是可以被反射攻击。所以做如下控制
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许构建多个单例实例");
        }
    }

    //懒汉式单例：LazyHolder里面的逻辑需要等到外部方法调用时才执行
    //利用了内部类的特性
    // 利用JVM底层执行逻辑，避免了线程安全问题？？？
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    //加载外部类LazyInnerClassSingleton时，会先加载这个内部类
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
