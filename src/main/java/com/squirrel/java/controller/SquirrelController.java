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


    @PostMapping("/log-demo")
    @SquLog
    public String logDemo() {
        // 生成并设置traceId
        String traceId = String.valueOf(UUID.randomUUID());
        MDC.put("traceId", traceId);

        log.info("主线程-方法执行中, traceId={}", traceId);

        ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));
        try {
            executorService.submit(() -> {
                String childTraceId = MDC.get("traceId");
                log.info("子线程-收到traceId={}", childTraceId);
            });
        } finally {
            executorService.shutdown();
        }

        return "{\"status\":\"success\",\"traceId\":\"" + traceId + "\"}";
    }

    @PostMapping("/mq/send")
    public String sendMqMessage() {
        producer.send();
        return "{\"status\":\"success\"}";
    }


    public static void main(String[] args) {

    }
}
