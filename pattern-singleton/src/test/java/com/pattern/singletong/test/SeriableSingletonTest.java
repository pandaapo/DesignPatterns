package com.pattern.singletong.test;

import com.pattern.singleton.seriable.SeriableSingletong;

import java.io.*;

// 利用序列化攻击单例
public class SeriableSingletonTest {

    public static void main(String[] args) {
        SeriableSingletong s1 = null;
        SeriableSingletong s2 = SeriableSingletong.getInstance();
        FileOutputStream fos = null;
        try {
            //先通过输出流将实例写入磁盘
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            //再通过输入流从磁盘将实例读取出来，利用反序列化的方式写入内存
            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingletong)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
