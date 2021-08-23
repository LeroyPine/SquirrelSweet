package com.squirrel.java.concurrence;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
 * @date Created in 2021年04月14日 13:18
 * @since 1.0
 */
public class AqsSelf extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();


        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            try {
                Thread.sleep(1000);
                System.out.println(1231);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });
        Thread.sleep(10);
        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println(123);
            try {

            } finally {
                reentrantLock.unlock();
            }
        });

        thread.start();
        thread1.start();


        // 读写锁
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        //
        Hashtable hashtable = new Hashtable();;

        //
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();

        //
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    }

}
