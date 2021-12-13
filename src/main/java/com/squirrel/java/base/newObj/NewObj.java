package com.squirrel.java.base.newObj;

public class NewObj {

    public static NewObj newObj = new NewObj();

    NewObj() {
        System.out.println("执行构造方法!!");
    }

    {
        System.out.println("我是实例代码块");
    }

    static {
        System.out.println("我是静态代码块");
    }

    public static void main(String[] args) {
        new NewObj();
    }
}
