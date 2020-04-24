package com.study.iocdi.aop;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyAdvice  implements    Advice {
    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Exception {
        //TODO 根据该方法的结构，可以知道可以进行各种增强处理
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        //TODO 可以调用结果时捕获异常，如果发生异常之后可以做进一步的处理
        Object res = method.invoke(target, args);
        System.out.println("----"+target.getClass().getName()+"耗时："+(System.currentTimeMillis() - start));
        //TODO 例如After处理，可以在返回之前对res进行修改处理
        return res;
    }
}
