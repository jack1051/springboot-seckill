package com.jesper.seckill.test.rabbitmq.Simple;

import com.jesper.seckill.test.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleRabbit {
    // 简单的点对点模式

    @Autowired
    RabbitTemplate rabbitTemplate;

    // 生产者
    public void send() throws Exception {

        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(RabbitConfig.SIMPLE, "发送：" + i);
            Thread.sleep(1000);
        }
    }
	// 消费者监听SIMPLE队列
    @RabbitListener(queues = RabbitConfig.SIMPLE)
    public void comsumer(String msg) {
    
        System.out.println("comsumer:" + msg);
    }

    // 消费者监听SIMPLE队列
    @RabbitListener(queues = RabbitConfig.SIMPLE)
    public void comsumer02(String msg) {

        System.out.println("comsumer02:" + msg);
    }
 }