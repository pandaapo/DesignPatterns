package com.pattern.proxy.dynamicproxy.jdkproxy;

import com.pattern.proxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class JDKProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKHunJieSuo().getInstance(new Girl());
            obj.findLove();

            //探索实现原理"通过字节码重组动态生成新的类"。将在内存中生成的新类$Proxy保存到磁盘，再反编译出来。
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy.class");
            os.write(bytes);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
