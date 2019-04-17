package com.pattern.proxy.dbroute.db;

public class DynamicDataSourceEntity {
    //一个常量
    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity(){}

    public static String get(){
        return local.get();
    }

    //每次切换数据源时需要重新set？？？
    //DB_2018 DB_2019
    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_" + year);
    }

    //重置
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }
}
