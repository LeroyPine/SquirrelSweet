package com.squirrel.java.concurrence;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

   /* @Autowired
    @Qualifier("squirrelThreadPool")
    private static ThreadPoolTaskExecutor squirrelPool;*/

    public static void main(String[] args) {

        // ThreadPoolExecutor

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future> futureList = new ArrayList<>();


        futureList.add(executor.submit(() -> {
            Thread.sleep(100000);
            System.out.println("task1");
            return "task1";
        }));


        futureList.add(executor.submit(() -> {
            System.out.println("task2");
            return "task2";
        }));

        futureList.add(executor.submit(() -> {
            System.out.println("task3");
            return "task3";
        }));

        futureList.forEach(s -> {
            try {
                Object o = s.get();
                log.info("result：{}", JSONObject.toJSONString(o));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });
    }


}
