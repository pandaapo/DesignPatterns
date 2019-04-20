package com.pattern.proxy.staticproxy;

import com.pattern.proxy.Person;

public class Father {
    private Son son;

    //通过构造方法，把“儿子”的引用传进来
    public Father(Son person) {
        this.son = person;
    }

    public void findLove(){
        System.out.println("父亲劝结");
        this.son.findLove();
        System.out.println("达成一致，欢欢喜喜");
    }
}
