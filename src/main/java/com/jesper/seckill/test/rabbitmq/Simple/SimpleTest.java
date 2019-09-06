package com.jesper.seckill.test.rabbitmq.Simple;

import com.jesper.seckill.MainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainApplication.class)
public class SimpleTest {

    @Autowired
    SimpleRabbit rabbit;
    
    @Test
    public void test() throws Exception {
        rabbit.send();
    }
}