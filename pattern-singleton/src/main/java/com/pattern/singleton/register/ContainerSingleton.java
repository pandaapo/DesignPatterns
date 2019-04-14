package com.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//注册式单例-容器式。例如spring用的就是这种单例
// 容器式单例，对象方便管理，其实也是属于懒加载
// 存在线程安全问题，所以加上synchronized
public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) {
        // synchronized()，括号里面是锁对象
        synchronized (ioc) {
            if(!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            }
            return ioc.get(className);
        }
    }
}
