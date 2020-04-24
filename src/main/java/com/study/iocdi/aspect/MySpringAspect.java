package com.study.iocdi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MySpringAspect {

    @Around(value = "execution(* com.study.iocdi.service.*.*(..))")
    public   Object   myAspect(ProceedingJoinPoint pjp){

        long start = System.currentTimeMillis();
        Object proceed =  null ;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("----"+pjp.getTarget()  + "，耗时"+(System.currentTimeMillis() - start));
        return proceed ;
    }

}
