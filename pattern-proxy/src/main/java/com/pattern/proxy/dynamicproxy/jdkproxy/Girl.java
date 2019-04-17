package com.pattern.proxy.dynamicproxy.jdkproxy;

import com.pattern.proxy.Person;

public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("能合作经营才结婚");
    }
}
