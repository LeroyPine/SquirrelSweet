package com.squirrel.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SquirrelProxy implements InvocationHandler {

    private String name;

    // 松鼠代理
    public SquirrelProxy(Squirrel squirrel) {
        this.squirrel = squirrel;
    }

    public SquirrelProxy(){

    }

    private Squirrel squirrel;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("我是代理");

        method.invoke(squirrel, args);

        System.out.println("我是代理结束了");

        return null;
    }


    public static void main(String[] args) {

        // 目标对象- 松鼠
        Squirrel squirrel = new Squirrel();
        // 代理对象
        SquirrelProxy squirrelProxy = new SquirrelProxy(squirrel);
        // 生成代理
        Eat sq = (Eat) Proxy.newProxyInstance(squirrel.getClass().getClassLoader(), squirrel.getClass().getInterfaces(), squirrelProxy);

        sq.eat();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
