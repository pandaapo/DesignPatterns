package com.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA();
        prototypeA.setAge(18);
        prototypeA.setName("pad");
        List hobbies = new ArrayList<String>();
        prototypeA.setHobbies(hobbies);

        //克隆上面的对象
        Client client = new Client();
        ConcretePrototypeA copy = (ConcretePrototypeA) client.startClone(prototypeA);
        System.out.println(copy);

        System.out.println("克隆对象中引用类型地址的值：" + copy.getHobbies());
        System.out.println("原型对象中引用类型地址的值：" + prototypeA.getHobbies());
        System.out.println("地址的比价：" + (copy.getHobbies() == prototypeA.getHobbies()));

    }
}
