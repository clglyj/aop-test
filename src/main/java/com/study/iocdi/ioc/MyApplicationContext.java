package com.study.iocdi.ioc;


import com.study.iocdi.aop.MyAspect;
import com.study.iocdi.proxy.MyInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class   MyApplicationContext  implements  ApplicationContext {

    private Map<String, Class<?>> beanMap = new HashMap<>();

    private MyAspect myAspect ;
    @Override
    public Object getBean(String beanName) {
        Object  bean = getObjectInstance(beanName);

        //判断当前接口是否被切中
        bean =  aopProxyEnhance(bean);

        return bean;
    }

    private Object aopProxyEnhance(Object bean) {

        //TODO 判断切面是否切到当前接口
        if(this.myAspect != null &&  bean.getClass().getName().matches(this.myAspect.getMyPointCut().getClassPart())){
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(),new MyInvocationHandler(this.myAspect,bean));
        }


        return bean ;
    }

    private  Object  getObjectInstance(String  beanName){
        try {
            return  this.beanMap.get(beanName).newInstance() ;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null ;
    }

    @Override
    public void registBean(String name, Class<?> clazz) {
        this.beanMap.put(name, clazz);
    }

    @Override
    public void setAspectj(MyAspect myAspect) {
        this.myAspect = myAspect ;
    }
}
