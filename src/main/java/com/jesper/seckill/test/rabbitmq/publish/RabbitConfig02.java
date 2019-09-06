package com.jesper.seckill.test.rabbitmq.publish;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig02 {
    public final static String PUB_SUB_EXCHANGE = "pub_sub"; // 发布订阅的交换机
    public final static String QUEUE_1 = "queue_1"; //队列1
    public final static String QUEUE_2 = "queue_2"; //队列2
    
    @Bean("queue_1")
    public  Queue QUEUE_1_Queue() {
        return new Queue(QUEUE_1, true, false, true);
    }
    @Bean("queue_2")
    public Queue QUEUE_2_Queue() {
        return new Queue(QUEUE_2, true, false, true);
    }

    @Bean("pub_sub")	// 交换机
    public Exchange pub_sub_Exchange(){
        return ExchangeBuilder.fanoutExchange(PUB_SUB_EXCHANGE).build();
    }

	// 使交换机与队列绑定
    @Bean
    public Binding binding_QUEUE_1(@Qualifier("queue_1") Queue queue, @Qualifier(PUB_SUB_EXCHANGE) Exchange exchange) {
    	// with是路由key,这模式默认为空就好
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
    @Bean
    public Binding binding_QUEUE_2(@Qualifier("queue_2") Queue queue, @Qualifier(PUB_SUB_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
}