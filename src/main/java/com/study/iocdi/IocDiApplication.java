package com.study.iocdi;

import com.study.iocdi.service.KafkaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocDiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(IocDiApplication.class, args);

        /**
         * advice  pointcut切入点
         */
        KafkaService kafkaService = context.getBean(KafkaService.class);
        kafkaService.studyKafka("AA");
        kafkaService.studyKafka("BB");
        kafkaService.studyKafka("CC");

    }

}
