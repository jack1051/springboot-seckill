package com.jesper.seckill.test.rabbitmq.publish;

import com.jesper.seckill.MainApplication;
import com.jesper.seckill.test.rabbitmq.Simple.SimpleRabbit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainApplication.class)
public class PublishTest {

//    @Autowired
//    SimpleRabbit rabbit;

    @Autowired
    FanoutRabbit fanoutRabbit;
    
    @Test
    public void test() throws Exception {
        fanoutRabbit.producer();
    }
}