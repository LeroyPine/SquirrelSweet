package com.squirrel.java.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author luobaosong
 * @date 2023-12-13 17:34
 */
@Slf4j
@Component

public class Consumer implements ChannelAwareMessageListener {

    @Override
    @RabbitListener(queues = "qu.nack")
    public void onMessage(Message message, Channel channel) throws Exception {

        log.info("mea:{}", message.toString());

        Thread.sleep(5000);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);


    }


}
