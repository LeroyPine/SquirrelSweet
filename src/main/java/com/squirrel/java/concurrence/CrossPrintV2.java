package com.squirrel.java.concurrence;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年04月11日 11:46
 * @since 1.0
 */
public class CrossPrintV2 implements Runnable {

    private volatile Integer count = 30;


    // 上一个线程
    private Object prev;
    // 当前线程
    private Object self;

    public CrossPrintV2(Object prev, Object self) {
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {

        while (count > 0) {

            // 获取到上一个线程的锁
            synchronized (prev) {

                synchronized (self) {

                    // 打印线程名称
                    System.out.println(Thread.currentThread().getName());
                    count--;
                    // 进行唤醒操作(其他线程抢占这个锁)
                    self.notifyAll();
                }

                // 释放上一个线程的锁
                try {
                    if (count == 0) {
                        prev.notifyAll();
                    } else {
                        prev.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    public static void main(String[] args) throws InterruptedException {

        final Object A = new Object();
        final Object B = new Object();
        final Object C = new Object();


        CrossPrintV2 cA = new CrossPrintV2(C, A);
        CrossPrintV2 cB = new CrossPrintV2(A, B);
        CrossPrintV2 cC = new CrossPrintV2(B, C);

        Thread a = new Thread(cA, "A");
        a.start();
        Thread.sleep(10);
        Thread b = new Thread(cB, "B");
        b.start();
        Thread.sleep(10);
        Thread c = new Thread(cC, "C");
        c.start();


    }

}
