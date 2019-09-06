package com.jesper.seckill.test.rabbitmq.routing;

import com.jesper.seckill.MainApplication;
import com.jesper.seckill.test.rabbitmq.publish.FanoutRabbit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainApplication.class)
public class RountTest {

//    @Autowired
//    SimpleRabbit rabbit;

    @Autowired
    RoutingRabbit routingRabbit;
    
    @Test
    public void test() throws Exception {
        routingRabbit.producer();
    }
}