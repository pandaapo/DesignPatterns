package com.pattern.singletong.test;

import com.pattern.singleton.register.EnumSingleton;
import com.pattern.singleton.seriable.SeriableSingletong;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class EnumSingletonTest {
//    // 验证反序列化无法破坏枚举注册式单例
//    public static void main(String[] args) {
//        EnumSingleton s1 = null;
//        EnumSingleton s2 = EnumSingleton.getInstance();
//        FileOutputStream fos = null;
//        try {
//            //先通过输出流将实例写入磁盘
//            fos = new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(s2);
//            oos.flush();
//            oos.close();
//
//            //再通过输入流从磁盘将实例读取出来，利用反序列化的方式写入内存
//            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            s1 = (EnumSingleton)ois.readObject();
//            ois.close();
//
//            System.out.println(s1);
//            System.out.println(s2);
//            System.out.println(s1 == s2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //验证反射无法破坏枚举注册式单例
    //JVM限制了枚举类型不能被反射创建
    public static void main(String[] args) {
        try {
            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton obj = (EnumSingleton)c.newInstance("Hello","201904141324");
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
