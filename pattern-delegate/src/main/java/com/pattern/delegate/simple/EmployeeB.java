package com.pattern.delegate.simple;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我开始干活了，我会架构，执行" + command);
    }
}
