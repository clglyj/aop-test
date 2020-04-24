
package com.study.iocdi.service.impl;

import com.study.iocdi.service.FlumeService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class FlumeServiceImpl  implements FlumeService {

    private Random  random =  new Random();
    private int  num = 5 ;

    @Override
    public void studyFlume(String name) {
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(num));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
