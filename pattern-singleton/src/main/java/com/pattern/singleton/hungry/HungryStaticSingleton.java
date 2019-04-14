package com.pattern.singleton.hungry;

public class HungryStaticSingleton {

    //类刚加载的时候(类还没有实例化)就创建实例。final为了保证实例不会被别的地方改掉。
    private static final HungryStaticSingleton hungrySingleton;

    // 不管是静态的字段，还是静态的代码块，都会在类刚加载的时候，立即初始化。
    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    //构造方法私有
    private HungryStaticSingleton() {}

    //提供全局的访问点
    public static HungryStaticSingleton getInstance() {
        return hungrySingleton;
    }
}
