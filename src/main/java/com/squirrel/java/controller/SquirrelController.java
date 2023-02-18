package com.squirrel.java.controller;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.squirrel.java.annoation.SquLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RestController
@RequestMapping("/squ")
public class SquirrelController {


    @PostMapping("/aspect")
    @SquLog
    public String squLog() {

        ArrayList list = new ArrayList();
        log.info("方法执行中");
        return "1";
    }



    @RequestMapping("/clientAbort")
    public String alarmClientAbortException(){
        int i =0;
        while (i<1000000000){
            i++;
        }
        return "success";
    }

    public static void main(String[] args) {


        while (true){
            System.out.println(1);
            new Thread().start();
        }

    }
}
