package com.squirrel.java.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author luobaosong
 * @date 2023-12-13 17:33
 */
@Slf4j
@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {


        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setMessageId(UUID.randomUUID().toString());
                return message;
            }
        };


        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("nack.exchange", "routing.nack.key", "LBS" + UUID.randomUUID(), messagePostProcessor);
        }

        log.info("send end");
    }

}
