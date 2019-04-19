package com.pattern.proxy.dynamicproxy.myproxy;

import com.pattern.proxy.Person;
import com.pattern.proxy.dynamicproxy.jdkproxy.Girl;
import com.pattern.proxy.dynamicproxy.jdkproxy.JDKHunJieSuo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class MyProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new MyHunJieSuo().getInstance(new Girl());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
