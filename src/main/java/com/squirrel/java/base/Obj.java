package com.squirrel.java.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Obj {

    private O o;
    private B b;

    public Obj() {
        this.o = new O();
        this.b = new B();
    }



    class O implements Come,Leave {

        @Override
        public void doCome() {
            System.out.println("我来了");
            skr();
            squCome("A");
        }

        @Override
        public void doLeave() {

        }
    }

    class B implements Leave {

        @Override
        public void doLeave() {
            System.out.println("我走了");
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ExecutionException, InterruptedException {

        HashMap map = new HashMap();
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        //hashMap.put();
        Obj obj = new Obj();
        obj.o.doCome();
        obj.b.doLeave();

        ReentrantLock lock = new ReentrantLock();
        lock.lock();;
        Method ass = obj.getClass().getMethod("ass");
        ass.invoke(obj,"");
        Constructor<?>[] constructors = obj.getClass().getConstructors();

        CountDownLatch latch = new CountDownLatch(2);
        latch.countDown();

        CyclicBarrier barrier = new CyclicBarrier(10);
      //  FutureTask s = new FutureTask();
        //s.get();
    }

}
