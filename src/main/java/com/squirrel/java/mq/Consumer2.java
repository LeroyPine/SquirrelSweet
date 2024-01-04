package com.squirrel.java.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author luobaosong
 * @date 2023-12-13 17:34
 */
@Slf4j
@Component

public class Consumer2 implements ChannelAwareMessageListener {

    @Override
   // @RabbitListener(queues = "test.con.que")
    public void onMessage(Message message, Channel channel) throws Exception {

        log.info("mea:{}", message.toString());

        Thread.sleep(10000);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);


    }


}
