package com.squirrel.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
    }
}
