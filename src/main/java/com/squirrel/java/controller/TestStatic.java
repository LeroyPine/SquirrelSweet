package com.squirrel.java.controller;

import java.util.concurrent.atomic.AtomicInteger;

public class TestStatic {


    private volatile Integer count = 0;

    public static void main(String[] args) throws InterruptedException {

        TestStatic testStatic = new TestStatic();
        testStatic.par();
        Thread.sleep(100000);
    }


    public void par() {

        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                if (i % 2 == 0) {
                    count++;
                } /*else {
                    count.addAndGet(-5);
                }*/
            }
        });


        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("count:" + count);
            }
        });

        t1.start();
        t2.start();

    }

}
