package com.squirrel.java.controller;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.squirrel.java.annoation.SquLog;
import com.squirrel.java.entity.Link;
import com.squirrel.java.mq.Producer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RestController
@RequestMapping("/squ")
public class SquirrelController {

    @Autowired
    private Producer producer;


    @PostMapping("/aspect")
    @SquLog
    public String squLog() {

        MDC.put("traceId", String.valueOf(UUID.randomUUID()));

        ArrayList list = new ArrayList();
        log.info("方法执行中");

        Link link = new Link();
        log.info("asdasda");


        ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

        executorService.submit(() -> log.info("子线程traceId"));


        return "1";
    }


    @RequestMapping("/mq")
    public String mq() {

        producer.send();

        return "success";
    }


    public static void main(String[] args) {

    }
}
