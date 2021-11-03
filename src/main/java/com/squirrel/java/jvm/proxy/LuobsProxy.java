package com.squirrel.java.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 */
public class LuobsProxy implements InvocationHandler {

    private Luobs luobs;

    public LuobsProxy(Luobs luobs){
        this.luobs = luobs;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before--");

        method.invoke(luobs);

        System.out.println("after--");

        return null;
    }
}
