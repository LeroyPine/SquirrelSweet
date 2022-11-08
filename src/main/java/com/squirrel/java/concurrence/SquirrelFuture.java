package com.squirrel.java.concurrence;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author luobaosong
 * @date 2022/7/20 11:26
 * @description
 **/
@Slf4j
public class SquirrelFuture {

    public Object completed() throws ExecutionException, InterruptedException, TimeoutException {



        return null;
    }

    @SneakyThrows
    public static void main(String[] args){
        List<Object> objects = Collections.emptyList();

        objects.forEach(s->{
            System.out.println(12);
        });
    }

}
