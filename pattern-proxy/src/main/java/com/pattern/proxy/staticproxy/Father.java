package com.pattern.proxy.staticproxy;

import com.pattern.proxy.Person;

public class Father {
    private Person person;

    //通过构造方法，把“儿子”的引用传进来
    public Father(Person person) {
        this.person = person;
    }

    public void findLove(){
        System.out.println("父亲劝结");
        this.person.findLove();
        System.out.println("达成一致，欢欢喜喜");
    }
}
