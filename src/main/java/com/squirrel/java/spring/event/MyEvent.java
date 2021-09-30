package com.squirrel.java.spring.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
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
 * @date Created in 2021年09月29日 11:28
 * @since 1.0
 */
@Getter
@Setter
public class MyEvent extends ApplicationEvent {

    // 第一滴血
    private String firstBlood;

    public MyEvent(Object source, String firstBlood) {
        super(source);
        this.firstBlood = firstBlood;
    }
}
