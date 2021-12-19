package com.squirrel.java.base;

public interface Come extends Leave,Wait{


    void doCome();


    default void squCome(String a) {
        System.out.println("你好");
    }

    default void skr() {
        System.out.println("skr");
    }
}
