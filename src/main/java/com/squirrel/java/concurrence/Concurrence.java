package com.squirrel.java.concurrence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

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
 * @date Created in 2021年03月23日 17:03
 * @since 1.0
 */
@Slf4j
@Component
public class Concurrence {
    public static void main(String[] args) throws InterruptedException {

        // ThreadPoolExecutor
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return 2 / 0;
        }).exceptionally(ex -> {
            System.out.println("ex:" + ex.getMessage());
            return 0;
        });
        completableFuture.join();

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("as","as");
        Thread.sleep(10000);
    }


}
