package com.pattern.singleton.seriable;

import java.io.Serializable;

public class SeriableSingletong implements Serializable {
    //序列化就是把内存中的状态通过转化成字节码的形式，从而转换成一个IO流，写入到其他地方（可以时磁盘、网络IO）
    //内存中状态给永久保存下来

    //反序列化就是将已经持久化的字节码内容，转换成IO流，通过IO流的读取，进而将读取的内容专换成java对象
    //在转换过程中会重新创建对象

    private static final SeriableSingletong singletong = new SeriableSingletong();

    private SeriableSingletong(){}

    public static SeriableSingletong getInstance(){
        return singletong;
    }

    //反序列化破坏单例的解决方案
    //重写readResolve方法，只不过是覆盖了反序列化出来的对象
    //还是创建了两次实例，只不过是发生在JVM层面，相对来说比较安全
    //之前反序列化出来的对象会被GC回收
    private Object readResolve () {
        return singletong;
    }

}
