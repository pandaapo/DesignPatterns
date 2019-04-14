package com.pattern.singleton.lazy;

public class LazySimpleSingleton {
    private static LazySimpleSingleton lazy = null;

    private LazySimpleSingleton () {}

    // 但是将synchronized写在方法上，可能会导致整个类被锁住，影响性能
    public synchronized static LazySimpleSingleton getInstance() {
        if(lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
