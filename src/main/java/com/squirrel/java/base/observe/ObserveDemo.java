package com.squirrel.java.base.observe;

public class ObserveDemo {


    public static void main(String[] args) {

        // 定义主体
        Subject subject = new Subject();

        // 声明监听者
        SquirrelObserve observe = new SquirrelObserve(subject);

        subject.setState(12);


    }
}
