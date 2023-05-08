package com.squirrel.java.controller;

import com.squirrel.java.face.ISquirrel;
import com.squirrel.java.proxy.Squirrel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.sql.Driver;

@Controller
@Slf4j
public class KeepAliveController {

    ThreadLocal userLocal = new ThreadLocal();
    /**
     * alive interface
     *
     * @return ok
     */
    @RequestMapping("/ok")
    @ResponseBody
    public String alive() {

        Class<KeepAliveController> keepAliveControllerClass = KeepAliveController.class;
        Method[] methods = keepAliveControllerClass.getMethods();
        userLocal.get();

        return "I'm alive";
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();


    }

}
