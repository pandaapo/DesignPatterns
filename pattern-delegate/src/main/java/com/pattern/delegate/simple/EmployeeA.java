package com.pattern.delegate.simple;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工A，我开始干活了，我会加密，执行" + command);
    }
}
