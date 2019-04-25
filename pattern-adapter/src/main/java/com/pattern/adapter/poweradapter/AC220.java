package com.pattern.adapter.poweradapter;

//220V交流电
public class AC220 {
    public int outputAC220V(){
        int output = 220;
        System.out.println("输出交流电流：" + output + "V");
        return  output;
    }
}
