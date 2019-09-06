package com.jesper.seckill.test.rabbitmq.publish;

import com.jesper.seckill.test.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutRabbit {

    @Autowired
    RabbitTemplate template;

    public void producer() {
        for (int i = 0; i < 50; i++) {
        	// ""是路由key,应为没有所以传的空
            template.convertAndSend(RabbitConfig02.PUB_SUB_EXCHANGE, "", i);
        }
    }

    // 队列1的消费者
    @RabbitListener(queues = RabbitConfig02.QUEUE_1)
    public void queues_1(Integer msg) {
        System.out.println("队列1的消费者：" + msg);
    }

    // 队列1的消费者
    @RabbitListener(queues = RabbitConfig02.QUEUE_2)
    public void queues_2(Integer msg) {
        System.out.println("队列2的消费者：" + msg);
    }
}