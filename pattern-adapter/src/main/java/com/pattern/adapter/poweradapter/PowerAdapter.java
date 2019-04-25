package com.pattern.adapter.poweradapter;

public class PowerAdapter implements DC5 {

    //对220V也要兼容。构造方法引入220
    public AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter,输入AC" + adapterInput + "V，输出DC" + adapterOutput + "5V");
        return adapterOutput;
    }
}
