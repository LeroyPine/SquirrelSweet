package com.squirrel.java.controller;

import com.squirrel.java.annoation.SquLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/squ")
public class SquirrelController {


    @PostMapping("/aspect")
    @SquLog
    public String squLog() {
        log.info("方法执行中");
        return "1";
    }

}
