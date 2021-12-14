package com.squirrel.java.spring.listener;

import com.alibaba.fastjson.JSONObject;
import com.squirrel.java.spring.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

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
 * @date Created in 2021年09月29日 14:22
 * @since 1.0
 */
@Slf4j
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {



    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info("EVENT:{}", JSONObject.toJSONString(event));
    }


}
