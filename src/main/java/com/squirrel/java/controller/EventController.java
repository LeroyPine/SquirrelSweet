package com.squirrel.java.controller;

import com.squirrel.java.spring.publish.MyEventPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
 * @date Created in 2021年09月29日 14:12
 * @since 1.0
 */
@RestController
@RequestMapping("/12")
public class EventController {

    @Autowired
    private EventController eventController;

    @Autowired
    private MyEventPublish myEventPublish;

    /**
     * alive interface
     *
     * @return ok
     */
    @RequestMapping("/publish/event")
    @ResponseBody
    public String publishEvent() {

        myEventPublish.publishEv();
        return "success";

    }



}
