package com.squirrel.java.concurrence;

import lombok.SneakyThrows;

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
 * @date Created in 2021年04月11日 11:20
 * @since 1.0
 */
public class CrossPrint implements Runnable {

    // 总的打印次数
    private volatile Integer printCount = 100;

    private static boolean startA = true;
    private static boolean startB = false;
    private static boolean startC = false;

    @SneakyThrows
    @Override
    public void run() {
        while (printCount > 0) {
            synchronized (CrossPrint.class) {
                if (printCount % 3 == 0) {
                    System.out.println("线程名称:" + Thread.currentThread() + "A");
                }
                if (printCount % 3 == 1) {
                    System.out.println("线程名称:" + Thread.currentThread() + "B");
                }
                if (printCount % 3 == 2) {
                    System.out.println("线程名称:" + Thread.currentThread() + "C");
                }
                printCount--;
            }
            // 线程休眠
            Thread.sleep(10);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        // 锁
        final Object o = new Object();


        Thread t1 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; ) {
                    if (startA) {
                        System.out.println(Thread.currentThread().getName());
                        startA = false;
                        startB = true;
                        startC = false;

                        o.notifyAll();
                        i++;
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }, "A");
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; ) {
                    if (startB) {
                        System.out.println(Thread.currentThread().getName());
                        startA = false;
                        startB = false;
                        startC = true;

                        o.notifyAll();
                        i++;
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }, "B");
        Thread t3 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; ) {
                    if (startC) {
                        System.out.println(Thread.currentThread().getName());
                        startA = true;
                        startB = false;
                        startC = false;

                        o.notifyAll();
                        i++;
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, "C");

        t1.start();
        Thread.sleep(10);
        t2.start();
        t3.start();


        /*   Thread.sleep(20000);*/
    }

}
