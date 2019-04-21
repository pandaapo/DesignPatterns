package com.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

//JDK是读取接口的信息
// CGLib是覆盖父类方法
//目的：都是生成一个新的类，去实现增强代码逻辑的功能。CGLib生成代理逻辑更复杂，生成效率低，但调用效率高，因为生成的FastClass包含了所有逻辑，不再需要反射调用。JDK生成代理逻辑简单，执行效率相对较低，每次都要反射动态调用。
//CGLib有个坑：CGLib不能代理final的方法。
public class CGlibTest {
    public static void main(String[] args) {
        try {
            //将代理生成的新的class文件输出到磁盘。
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://");
            //对被代理对象没有任何要求
            Customer obj = (Customer)new CGlibHunJieSuo().getInstance(Customer.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
