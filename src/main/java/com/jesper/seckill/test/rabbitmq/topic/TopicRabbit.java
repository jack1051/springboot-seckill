package com.jesper.seckill.test.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicRabbit {

    @Autowired
    RabbitTemplate template;

    public void producer() {
        for (int i = 0; i < 5; i++) {
            template.convertAndSend(RabbitConfig04.TOPIC_EXCHANGE, "aa.bb", i);
        }
    }

    // 队列1的消费者
    @RabbitListener(queues = RabbitConfig04.TOPIC_1)
    public void queues_1(Integer msg) {
        System.out.println("队列1的消费者：" + msg);
    }

    // 队列1的消费者
    @RabbitListener(queues = RabbitConfig04.TOPIC_2)
    public void queues_2(Integer msg) {
        System.out.println("队列2的消费者：" + msg);
    }
}