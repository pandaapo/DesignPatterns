package com.pattern.singleton.hungry;

public class HungrySingleton {

    //类刚加载的时候(类还没有实例化)就创建实例
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    //构造方法私有
    private HungrySingleton() {}

    //提供全局的访问点
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
