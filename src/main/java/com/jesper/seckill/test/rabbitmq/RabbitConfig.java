package com.jesper.seckill.test.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public final static String SIMPLE = "simple";   // 队列名称

    @Bean
    public Queue simpleQueue() {	// 返回一个bean
        return new Queue(SIMPLE, true, false, true);
    }
}