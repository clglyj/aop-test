package com.study.iocdi.proxy;

import com.study.iocdi.aop.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private MyAspect myAspect ;

    private  Object   target ;

    public MyInvocationHandler(MyAspect myAspect, Object target) {
        this.myAspect = myAspect;
        this.target = target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if(method.getName().matches(this.myAspect.getMyPointCut().getMethodPart())){
           //TODO  切面里边有调用方法
           return  this.myAspect.getMyAdvice().invoke(target,method,args);
       }


//这里做测试


        return method.invoke(target,args);
    }
}
