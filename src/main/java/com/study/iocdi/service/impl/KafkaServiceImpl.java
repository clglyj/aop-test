package com.study.iocdi.service.impl;

import com.study.iocdi.service.KafkaService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaServiceImpl  implements KafkaService {
    private Random  random =  new Random();
    private int  num = 5 ;

    //TODO  CTRL+ALT+B  查看接口方法的实现
    @Override
    public void studyKafka(String name) {

        try {
            TimeUnit.SECONDS.sleep(random.nextInt(num));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
