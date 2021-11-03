package com.squirrel.java.jvm.proxy;

import java.lang.reflect.Proxy;

public class Client {


    public static void main(String[] args) {

        Luobs luobs = new Luobs();

        // 代理
        LuobsProxy luobsProxy = new LuobsProxy(luobs);

        Squirrel squirrel = (Squirrel) Proxy.newProxyInstance(LuobsProxy.class.getClassLoader(), luobs.getClass().getInterfaces(), luobsProxy);

        squirrel.eat();



    }

}
