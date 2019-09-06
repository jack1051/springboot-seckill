package com.jesper.seckill.test.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutingRabbit {

    @Autowired
    RabbitTemplate template;

    public void producer(){
        for (int i = 0; i < 20; i++) {
          if (i<11) {
              template.convertAndSend(RabbitConfig03.ROUTING_EXCHANGE, RabbitConfig03.ROUTING_1, i + "Routingmsg");
          }else {
              template.convertAndSend(RabbitConfig03.ROUTING_EXCHANGE, RabbitConfig03.ROUTING_2, i + "Routingmsg");
          }
        }
    }

    // 队列1的消费者
    @RabbitListener(queues = RabbitConfig03.ROUTING_1)
    public void queues_1(String msg) {
        System.out.println("队列1的消费者：" + msg);
    }

    // 队列1的消费者
    @RabbitListener(queues = RabbitConfig03.ROUTING_2)
    public void queues_2(String msg) {
        System.out.println("队列2的消费者：" + msg);
    }

}