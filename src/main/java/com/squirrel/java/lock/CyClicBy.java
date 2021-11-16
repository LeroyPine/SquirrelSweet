package com.squirrel.java.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyClicBy {



    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier lock = new CyclicBarrier(10);
        int await = lock.await();
    }
}
