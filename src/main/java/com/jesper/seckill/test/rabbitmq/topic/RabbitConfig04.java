package com.jesper.seckill.test.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig04 {
    public final static String TOPIC_EXCHANGE = "TOPIC_EXCHANGE01"; // 路由的交换机
    public final static String TOPIC_1 = "routing_1"; //topic队列1
    public final static String TOPIC_2 = "routing_2"; //topic队列2

    @Bean(TOPIC_1)
    public Queue TOPIC_1_Queue() {
        return new Queue(TOPIC_1, true, false, true);
    }

    @Bean(TOPIC_2)
    public Queue TOPIC_2_Queue() {
        return new Queue(TOPIC_2, true, false, true);
    }

    @Bean(TOPIC_EXCHANGE)
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE).build();
    }

    @Bean
    public Binding binding_Topic_QUEUE_1(@Qualifier(TOPIC_1) Queue queue, @Qualifier(TOPIC_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("aa.bb.cc").noargs();
    }
    @Bean
    public Binding binding_Topic_QUEUE_2(@Qualifier(TOPIC_2) Queue queue, @Qualifier(TOPIC_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("aa.#").noargs();
    }
}
