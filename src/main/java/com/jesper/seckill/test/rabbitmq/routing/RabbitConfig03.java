package com.jesper.seckill.test.rabbitmq.routing;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig03 {

    public final static String ROUTING_EXCHANGE = "routing1"; // 路由的交换机
    public final static String ROUTING_1 = "routing_1"; //routing队列1
    public final static String ROUTING_2 = "routing_2"; //routing队列2

    @Bean("routing_1")
    public Queue OUTING_1_Queue() {
        return new Queue(ROUTING_1, true, false, true);
    }

    @Bean("routing_2")
    public Queue ROUTING_2_Queue() {
        return new Queue(ROUTING_2, true, false, true);
    }

    @Bean(ROUTING_EXCHANGE)
    public Exchange routingExchange(){
        return ExchangeBuilder.directExchange(ROUTING_EXCHANGE).build();
    }

    @Bean
    public Binding binding_Routing_QUEUE_1(@Qualifier(ROUTING_1) Queue queue, @Qualifier(ROUTING_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_1).noargs();
    }
    @Bean
    public Binding binding_Routing_QUEUE_2(@Qualifier(ROUTING_2) Queue queue, @Qualifier(ROUTING_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_2).noargs();
    }
}
