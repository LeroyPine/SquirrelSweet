package com.squirrel.java.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Sync {

    // sync
    private final Object sync = new Object();

    public synchronized void sync() {
        System.out.println("You are beautiful,come on!");
    }

    public void syncS() {
        synchronized (sync) {
            System.out.println("I m get this");
        }
    }

    // lock
    ReentrantLock lock = new ReentrantLock();

    public void lock() {
        lock.lock();
        try {
            System.out.println("I love you");
        } finally {
            lock.unlock();
        }
    }


}
