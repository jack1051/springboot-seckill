package com.jesper.seckill.test.rabbitmq.topic;

import com.jesper.seckill.MainApplication;
import com.jesper.seckill.test.rabbitmq.routing.RoutingRabbit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainApplication.class)
public class TopicTest {

//    @Autowired
//    SimpleRabbit rabbit;

    @Autowired
    TopicRabbit topicRabbit;
    
    @Test
    public void test() throws Exception {
        topicRabbit.producer();
    }
}