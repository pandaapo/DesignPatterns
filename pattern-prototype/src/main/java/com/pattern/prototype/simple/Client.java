package com.pattern.prototype.simple;

//接收原型
public class Client {
    public Prototype startClone(Prototype prototype){
        return prototype.clone();
    }
}
