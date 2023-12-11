package com.squirrel.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Slf4j
@Component
public class GcController implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
           log.info("niubi~~~");
        }, 0, 10, TimeUnit.SECONDS);

        new Thread(()->{
            String as = "q25q";
            synchronized (as){
                try {
                    as.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
