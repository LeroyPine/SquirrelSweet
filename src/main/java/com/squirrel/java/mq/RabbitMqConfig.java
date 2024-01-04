package com.squirrel.java.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author luobaosong
 * @date 2023-12-13 17:44
 */
@Configuration
public class RabbitMqConfig {


    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("test");
        return connectionFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(CachingConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        factory.setPrefetchCount(1);
        return factory;
    }

    public static String null2String(Object o) {
        return null2String(o, "");
    }


    public static String null2String(Object o, String defVal) {
        return !isBlank(o) ? o.toString() : defVal;
    }

    public static boolean isBlank(Object o) {
        return null == o || o.toString().trim().length() == 0 || "null".equalsIgnoreCase(o.toString());
    }

    public static <T> List<T> createList(T... objs) {
        List<T> list = new LinkedList<T>();
        for (T obj : objs) {
            list.add(obj);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer i = tranDataMapping(30, mapHouseinfo());
        System.out.println(i);
    }


    public static Integer tranDataMapping(Integer it, Map<Integer, Integer> map) {
        Integer rt = null;
        if (null == it || "".equals(it)) {
            return rt;
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (it.equals(entry.getKey())) {
                    rt = entry.getValue();
                    break;
                }
            }
        }
        return rt;
    }



    public static Map<Integer, Integer> mapHouseinfo() {
        // 户型相关
        Map<Integer, Integer> rtMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <= 20; i++) {
            if (i < 21) {
                rtMap.put(i, i);
            } else {
                rtMap.put(i, 99);
            }
        }
        return rtMap;
    }


}
