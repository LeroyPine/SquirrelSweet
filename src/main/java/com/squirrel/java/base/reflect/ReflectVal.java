package com.squirrel.java.base.reflect;

public class ReflectVal {

    public void rel() throws ClassNotFoundException {
        Class<? extends ReflectVal> aClass = this.getClass();
        Class<?> com = Class.forName("com");
        Class<ReflectVal> reflectValClass = ReflectVal.class;
    }
}
