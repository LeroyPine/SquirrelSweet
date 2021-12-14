package com.squirrel.java.spring.publish;

import com.squirrel.java.spring.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

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
 * @date Created in 2021年09月29日 11:24
 * @since 1.0
 */
@Service
public class MyEventPublish {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public void publishEv() {
        applicationEventPublisher.publishEvent(new MyEvent(MyEventPublish.class.getSimpleName(), "发送事件1"));
    }
}
