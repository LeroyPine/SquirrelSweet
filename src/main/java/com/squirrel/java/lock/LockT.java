package com.squirrel.java.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.*;

public class LockT {

    public static ReentrantLock lock = new ReentrantLock();

    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
      lock.lock();

        Lock lock = readWriteLock.readLock();
        lock.lock();

        Lock lock1 = readWriteLock.writeLock();


        StringBuilder builder = new StringBuilder();

        StringBuffer buffer =  new StringBuffer();

        Condition condition = lock.newCondition();



    }
}
