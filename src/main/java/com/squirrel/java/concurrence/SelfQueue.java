package com.squirrel.java.concurrence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.DelayQueue;

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
 * @date Created in 2021年04月23日 14:52
 * @since 1.0
 */
public class SelfQueue {


    DelayQueue delayQueue = new DelayQueue<>();

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            System.out.println("I will success!!!");
        });
    }
}
