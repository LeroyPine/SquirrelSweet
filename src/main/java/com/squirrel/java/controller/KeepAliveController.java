package com.squirrel.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class KeepAliveController {

    /**
     * alive interface
     *
     * @return ok
     */
    @RequestMapping("/ok")
    @ResponseBody
    public String alive() {
        return "I'm alive";
    }

}
