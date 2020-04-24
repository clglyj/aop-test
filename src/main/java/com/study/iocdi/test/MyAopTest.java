package com.study.iocdi.test;

import com.study.iocdi.aop.MyAdvice;
import com.study.iocdi.aop.MyAspect;
import com.study.iocdi.aop.MyPointCut;
import com.study.iocdi.ioc.ApplicationContext;
import com.study.iocdi.ioc.MyApplicationContext;
import com.study.iocdi.service.FlumeService;
import com.study.iocdi.service.KafkaService;
import com.study.iocdi.service.impl.FlumeServiceImpl;
import com.study.iocdi.service.impl.KafkaServiceImpl;

/**
 * 总体思路：
 * 在获取bean的时候，判断当前bean是否被切面切中，切中则需要通过advice进行增强
 * 通过advice增强需要用到动态代理，方法调用时需要
 * 未切中直接返回bean对象即可
 */
public class MyAopTest {
    public static void main(String[] args) {
        MyAdvice myAdvice = new MyAdvice();
        MyPointCut myPointCut = new MyPointCut("com\\.study\\.iocdi\\.service\\..*", "study.*");
        MyAspect myAspect = new MyAspect(myAdvice, myPointCut);

//        KafkaService kafkaService = new KafkaServiceImpl();
//        kafkaService.studyKafka("AA");

        ApplicationContext context = new MyApplicationContext();


        context.registBean("kafka",KafkaServiceImpl.class);
        context.registBean("flume",FlumeServiceImpl.class);
        //配置切面
        context.setAspectj(myAspect);

        KafkaService kafkaService = (KafkaService)context.getBean("kafka");
        FlumeService flumeService = (FlumeService)context.getBean("flume");
        //IOC是AOP的基石
        kafkaService.studyKafka("AA");
        //需要实现IOC
        flumeService.studyFlume("BB");


    }
}
