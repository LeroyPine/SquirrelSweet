package com.squirrel.java.theadpool;

import java.util.concurrent.*;

public class SquirrelPool {


    ThreadPoolExecutor squirrelP = new ThreadPoolExecutor(9, 20, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue(20)
    );


    public void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(19);
        Executors.newScheduledThreadPool(10);


    }
}
