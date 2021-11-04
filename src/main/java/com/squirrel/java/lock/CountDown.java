package com.squirrel.java.lock;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class CountDown {


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(2);
        Thread one = new Thread(new MyThread(1000,latch));
        Thread two = new Thread(new MyThread(5000,latch));

        one.start();
        two.start();
        System.out.println("我是主线程skr");

        latch.await();
        System.out.println("主线程运行结束----");

    }


    static class MyThread implements Runnable {

        private final Integer time;
        private CountDownLatch latch;

        MyThread(Integer time, CountDownLatch latch) {
            this.time = time;
            this.latch = latch;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "：开始");
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + "：结束");
            latch.countDown();
        }
    }
}
