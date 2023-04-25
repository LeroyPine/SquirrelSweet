package com.squirrel.java.theadpool;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SquirrelPool {

    volatile Integer count = 10000;

    public static void main(String[] args) {
        SquirrelPool pool = new SquirrelPool();
        pool.test();
    }

    public void test() {

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(5000);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS,
                linkedBlockingQueue, new ThreadPoolExecutor.AbortPolicy());

        long start = System.currentTimeMillis();

        log.info("sta",start);

        CountDownLatch countDownLatch = new CountDownLatch(5000);

        for (int i = 0; i < 5000; i++) {

            poolExecutor.submit(new TestThread(countDownLatch));

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("end time:{}", System.currentTimeMillis() - start);

    }


    @Data
    class TestThread implements Runnable {

        private CountDownLatch count;

        TestThread(CountDownLatch downLatch) {
            this.count = downLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(150);
                count.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
